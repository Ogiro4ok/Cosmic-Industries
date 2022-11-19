package ci.content;

import arc.graphics.Color;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class CosmicIndustriesUnits {
    public static UnitType
            //core units
            falcon;

    public static void load() {

        falcon  = new UnitType("falcon") {{
            aiController = BuilderAI::new;
            isEnemy = false;
            constructor = UnitEntity::create;
            lowAltitude = true;
            flying = true;
            mineTier = 1;
            mineSpeed = 7f;
            drag = 0.05f;
            accel = 0.1f;
            speed = 3.6f;
            rotateSpeed = 15f;
            buildSpeed = 0.90f;
            itemCapacity = 40;
            health = 360;
            engineOffset = 6f;
            hitSize = 9f;
            alwaysUnlocked = true;
            outlineColor = Color.darkGray;
            outlineRadius = 3;

            weapons.add(new Weapon("ci-falcon-weapon"){{
                top = false;
                reload = 45f;
                mirror = false;
                x = 0f;
                y = 0f;
                rotate = false;
                shoot.shots = 2;
                shoot.shotDelay = 3f;

                ejectEffect = Fx.none;

                bullet = new MissileBulletType(3.6f, 24){{
                    width = 5f;
                    height = 8f;

                    homingPower = 0.1f;
                    homingRange = 90;

                    lifetime = 50f;

                    shootSound = Sounds.missile;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    buildingDamageMultiplier = 0.001f;
                }};
            }});
        }};
    }
}