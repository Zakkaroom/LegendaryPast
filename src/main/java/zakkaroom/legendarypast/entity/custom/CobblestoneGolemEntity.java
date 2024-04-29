package zakkaroom.legendarypast.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.CamelEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import zakkaroom.legendarypast.entity.ai.CobblestoneGolemAttackGoal;

public class CobblestoneGolemEntity extends GolemEntity {

    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(CobblestoneGolemEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;


    public CobblestoneGolemEntity(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    private void setupAnimationStates(){
        if (this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = this.random.nextInt(40)+80;
            this.idleAnimationState.start(this.age);
        }else{
            --this.idleAnimationTimeout;
        }

        if (this.isAttacking() && attackAnimationTimeout <= 0){
            idleAnimationTimeout = 30;
            attackAnimationState.start(this.age);
        }else{
            --this.attackAnimationTimeout;
        }

        if (!this.isAttacking()){
            attackAnimationState.stop();
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient){
            setupAnimationStates();
        }
    }

    public void setAttacking(boolean attacking){
        this.dataTracker.set(ATTACKING,attacking);
    }

    @Override
    public boolean isAttacking(){
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    public void initDataTracker(){
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING,false);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new CobblestoneGolemAttackGoal(this, 1.0, true));
        this.targetSelector.add(1,new RevengeGoal(this));
        this.targetSelector.add(3, new ActiveTargetGoal<MobEntity>(this, MobEntity.class, 5, false, false, entity -> entity instanceof Monster && !(entity instanceof CreeperEntity)));
    }

    public static DefaultAttributeContainer.Builder createCobblestoneGolemAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH,30)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,3)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.3f);
    }
}
