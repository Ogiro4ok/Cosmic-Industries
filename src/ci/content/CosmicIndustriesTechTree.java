package ci.content;


import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.Liquid;

import static mindustry.content.TechTree.nodeProduce;
import static mindustry.content.TechTree.nodeRoot;

public class CosmicIndustriesTechTree {
    public static void load() {
        CosmicIndustriesPlanets.novia.techTree = nodeRoot("Novia", CosmicIndustriesBlocks.coreHeart, () -> {
            nodeProduce(CosmicIndustriesBlocks.shoker, () -> {
                    });
            nodeProduce(CosmicIndustriesItems.iron, () -> {
            });
        });
    }
}