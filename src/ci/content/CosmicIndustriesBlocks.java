package ci.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.LightningBulletType;
import mindustry.entities.bullet.PointLaserBulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ContinuousTurret;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawFlame;
import mindustry.world.draw.DrawMulti;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Env;

import static mindustry.type.ItemStack.with;

public class CosmicIndustriesBlocks {
    public static Block
    //environment
    hematiteOre, ironOre, duneSand,

    //crafting
    litiumSmelter,

    //turrets
    shoker, test, plasma,

    //defense
    ironWall, ironWallLarge,

    //drills
    ironDrill,

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

        //crafting

        litiumSmelter = new GenericCrafter("litiumSmelter"){{
            requirements(Category.crafting, with(CosmicIndustriesItems.iron, 80));
            craftTime = 70f;
            size = 2;
            hasPower = true;
            hasLiquids = false;
            consumeItems(with(Items.silicon, 2, CosmicIndustriesItems.iron, 1));
            outputItem = new ItemStack(CosmicIndustriesItems.lithium, 2);
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef84")));
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.09f;
            craftEffect = Fx.smeltsmoke;
            consumePower(0.80f);
        }};

        //turrets

        shoker = new PowerTurret("shoker") {{
        requirements(Category.turret, with(CosmicIndustriesItems.iron, 50));
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
        consumePower(0.4f);
    }};

        test = new ItemTurret("test") {{
        requirements(Category.turret, with(CosmicIndustriesItems.iron, 170, CosmicIndustriesItems.hematite, 80));
        ammo(
        CosmicIndustriesItems.hematite,  new BasicBulletType(4.3f, 60){{
            shoot = new ShootSpread(7, 6f);
            shoot.shotDelay = 3;
            height = 11f;
            width = 10f;
            lifetime = 73f;

            }});

            reload = 45f;
            shootCone = 40f;
            rotateSpeed = 1.20f;
            targetAir = true;
            targetGround = false;
            range = 325f;
            recoil = 1.3f;
            size = 3;
            health = 445;
            ammoPerShot = 2;
            shootSound = Sounds.artillery;
            consumePower(0.5f);
        }};

        plasma = new ContinuousTurret("plasma") {{
            requirements(Category.turret, with(CosmicIndustriesItems.iron, 240, CosmicIndustriesItems.hematite, 120, CosmicIndustriesItems.lithium, 40));
            shootType = new PointLaserBulletType(){{
                damage = 83f;
                buildingDamageMultiplier = 0.3f;
                hitColor = Color.valueOf("fda981");
            }};
            shootSound = Sounds.none;
            loopSoundVolume = 1f;
            loopSound = Sounds.laserbeam;
            shootWarmupSpeed = 0.08f;
            shootCone = 360f;
            aimChangeSpeed = 999f;
            rotateSpeed = 999f;
            shootY = 0.1f;
            outlineColor = Pal.darkOutline;
            size = 3;
            envEnabled |= Env.space;
            range = 230f;
            scaledHealth = 210;
            health = 570;
            consumePower(3.4f);
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

        //drills

        ironDrill = new Drill("ironDrill") {{
            requirements(Category.production, with(CosmicIndustriesItems.iron, 24));
            tier = 2;
            drillTime = 350;
            size = 2;
            alwaysUnlocked = true;
        }};

        //storage

        coreHeart = new CoreBlock("coreHeart") {{
            requirements(Category.effect, BuildVisibility.editorOnly, with( CosmicIndustriesItems.iron, 800, CosmicIndustriesItems.hematite, 1200));
            alwaysUnlocked = true;

            isFirstTier = true;
            unitType = CosmicIndustriesUnits.falcon;
            health = 2000;
            itemCapacity = 3000;
            size = 4;
            unitCapModifier = 8;
        }};
    }
}