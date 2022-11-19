package ci.content;

import arc.graphics.Color;
import ci.planets.NoviaPlanetGenerator;
import mindustry.Vars;
import mindustry.content.Planets;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.type.ItemStack;
import mindustry.type.Planet;

public class CosmicIndustriesPlanets {
    public static Planet
            novia;
    public static void load(){
        novia = new Planet("novia", Planets.sun, 1f, 2){{
            defaultCore = CosmicIndustriesBlocks.coreHeart;
            sectorSeed = 23;
            generator = new NoviaPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 6, 0.1f, 0.23f, 5, Color.valueOf("FFFFFF").a(0.75f), 2, 0.45f, 1.13f, 0.45f),
                    new HexSkyMesh(this, 3, 0.2f, 0.19f, 5, Color.valueOf("FFFFFF").a(0.65f), 3, 0.25f, 1.22f, 0.45f));
            accessible = true;
            alwaysUnlocked = true;
            atmosphereColor = Color.valueOf("B79E54");
            startSector = 12;
            atmosphereRadIn = 0.01f;
            atmosphereRadOut = 0.4f;
            clearSectorOnLose = true;
            ruleSetter = r -> {
                r.loadout = ItemStack.list(CosmicIndustriesItems.hematite, 50);
                r.waveTeam = Team.blue;
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
