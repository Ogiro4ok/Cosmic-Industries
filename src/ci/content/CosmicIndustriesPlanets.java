package ci.content;

import arc.graphics.Color;
import arc.math.geom.Mat3D;
import arc.util.Tmp;
import ci.planets.NoviaPlanetGenerator;
import ci.planets.OctaviaPlanetGenerator;
import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.Planets;
import mindustry.game.Team;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.AsteroidGenerator;
import mindustry.type.ItemStack;
import mindustry.type.Planet;
import mindustry.type.Sector;
import mindustry.world.meta.Env;

import static mindustry.entities.TargetPriority.base;

public class CosmicIndustriesPlanets {
    public static Planet
            plumia, novia, octavia, quantix;

    public static void load() {
        Planets.serpulo.hiddenItems.addAll(Vars.content.items()).removeAll(Items.serpuloItems);
        Planets.erekir.hiddenItems.addAll(Vars.content.items()).removeAll(Items.erekirItems);

        plumia = new Planet("plumia", Planets.sun, 5, 5) {{
            accessible = false;
            meshLoader = () -> new SunMesh(
                    this, 4,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("61d8d9"),
                    Color.valueOf("00baff"),
                    Color.valueOf("d1f3ff"),
                    Color.valueOf("84cde9"),
                    Color.valueOf("52b9df"),
                    Color.valueOf("0ca2da")
            );
            bloom = true;
            drawOrbit = false;
            atmosphereColor = Color.valueOf("0ca2da");
            orbitRadius = 666;
        }};

        novia = new Planet("novia", CosmicIndustriesPlanets.plumia, 1f, 2) {{
            defaultCore = CosmicIndustriesBlocks.coreHeart;
            sectorSeed = 8;
            generator = new NoviaPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 5);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 6, 0.1f, 0.23f, 5, Color.valueOf("FFFFFF").a(0.75f), 2, 0.45f, 1.13f, 0.45f),
                    new HexSkyMesh(this, 3, 0.2f, 0.19f, 5, Color.valueOf("FFFFFF").a(0.65f), 3, 0.25f, 1.22f, 0.45f));
            solarSystem = plumia;
            accessible = true;
            alwaysUnlocked = true;
            atmosphereColor = Color.valueOf("B79E54");
            startSector = 32;
            atmosphereRadIn = 0.01f;
            atmosphereRadOut = 0.4f;
            clearSectorOnLose = true;
            ruleSetter = r -> {
                r.loadout = ItemStack.list(CosmicIndustriesItems.iron, 40);
                r.waveTeam = Team.blue;
                r.attributes.clear();
                r.showSpawns = true;
                r.fog = false;
                r.onlyDepositCore = false;
            };
            unlockedOnLand.add(CosmicIndustriesBlocks.coreHeart);
            hiddenItems.addAll(Vars.content.items()).removeAll(CosmicIndustriesItems.noviaItems);
        }};

        octavia = new Planet("octavia", CosmicIndustriesPlanets.plumia, 1f, 2) {{
            defaultCore = CosmicIndustriesBlocks.coreHeart;
            sectorSeed = 55;
            generator = new OctaviaPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 5);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 6, 0.1f, 0.23f, 5, Color.valueOf("FFFFFF").a(0.75f), 2, 0.45f, 1.13f, 0.45f),
                    new HexSkyMesh(this, 3, 0.2f, 0.19f, 5, Color.valueOf("FFFFFF").a(0.65f), 3, 0.25f, 1.22f, 0.45f));
            solarSystem = plumia;
            accessible = true;
            alwaysUnlocked = true;
            atmosphereColor = Color.valueOf("d7ff7c");
            startSector = 0;
            atmosphereRadIn = 0.f;
            atmosphereRadOut = 0.3f;
            clearSectorOnLose = true;
            orbitRadius = 64;
            ruleSetter = r -> {
                r.loadout = ItemStack.list(CosmicIndustriesItems.iron, 40);
                r.waveTeam = Team.green;
                r.attributes.clear();
                r.showSpawns = true;
                r.fog = false;
                r.onlyDepositCore = false;
            };
            unlockedOnLand.add(CosmicIndustriesBlocks.coreHeart);
            hiddenItems.addAll(Vars.content.items()).removeAll(CosmicIndustriesItems.noviaItems);

        }};

    }
}
