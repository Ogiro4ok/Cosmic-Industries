package ci.content;

import arc.graphics.*;
import arc.struct.Seq;
import mindustry.type.*;

public class CosmicIndustriesItems {
        public static Item hematite, iron, lithium;

    public static final Seq<Item> noviaItems = new Seq<>();
    public static void load() {
        hematite = new Item("hematite", Color.valueOf("ffc88cff")) {{
            hardness = 1;
        }};
        iron = new Item("iron", Color.valueOf("5b5b5bff")) {{
            hardness = 1;
        }};
        lithium = new Item("lithium") {{
            explosiveness = 2;
        }};
        noviaItems.addAll(
        iron, hematite, lithium
        );
    }
}