package ci.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.with;

public class CosmicIndustriesBlocks {
    public static Block
    //environment
    hematiteOre, ironOre, duneSand,

    //turrets
    shoker,

    //defense
    ironWall, ironWallLarge,

    //storage
    coreHeart;

    public static void load() {

        //environment
        ironOre= new OreBlock(CosmicIndustriesItems.iron) {{
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};
        hematiteOre= new OreBlock(CosmicIndustriesItems.hematite) {{
            oreDefault = true;
            oreThreshold = 0.93f;
            oreScale = 21.42365f;
        }};

        duneSand = new Floor("duneSand") {{
            variants = 2;
        }};

        //turrets
        shoker = new PowerTurret("shoker") {{
        requirements(Category.turret, with(CosmicIndustriesItems.iron, 25));
        shootType = new LightningBulletType(){{
            damage = 5;
            lightningLength = 10;
            collidesAir = true;
            ammoMultiplier = 1f;

            buildingDamageMultiplier = 0.25f;

            lightningType = new BulletType(0.0001f, 0f){{
                lifetime = Fx.lightning.lifetime;
                hitEffect = Fx.hitLancer;
                despawnEffect = Fx.none;
                status = StatusEffects.shocked;
                statusDuration = 10f;
                hittable = false;
                lightColor = Color.yellow;
                collidesAir = true;
                buildingDamageMultiplier = 0.25f;
            }};
        }};
        reload = 12.5f;
        shootCone = 40f;
        rotateSpeed = 4f;
        targetAir = true;
        range = 60f;
        shootEffect = Fx.lightningShoot;
        heatColor = Color.red;
        recoil = 1f;
        size = 1;
        health = 260;
        shootSound = Sounds.spark;
        consumePower(3.3f);
        coolant = consumeCoolant(0.1f);
    }};

        //defence

        ironWall = new Wall("ironWall") {{
            size = 1;
            health = 120;
            requirements(Category.defense, with(CosmicIndustriesItems.iron,6));
        }};
        ironWallLarge = new Wall("ironWallLarge") {{
            size = 2;
            health = 260;
            requirements(Category.defense, with(CosmicIndustriesItems.iron,24));
        }};
        //storage

        coreHeart = new CoreBlock("coreHeart") {{
            requirements(Category.effect, BuildVisibility.editorOnly, with( Items.graphite, 600, Items.lead, 800));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = CosmicIndustriesUnits.falcon;
            health = 1000;
            itemCapacity = 1000;
            size = 4;
            unitCapModifier = 6;
        }};
    }
}