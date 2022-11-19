package ci.content;

import arc.graphics.Color;
import mindustry.content.Liquids;
import mindustry.type.Liquid;

public class CosmicIndustriesLiquids {
    public static Liquid carbon, oxygen, helium;

    public static void load() {
        carbon = new Liquid("carbon", Color.valueOf("7B7771FF")) {{
            gas = true;
        }};
        oxygen = new Liquid("oxygen", Color.valueOf("B6CACAFF")) {{
            gas = true;
        }};
        helium = new Liquid("helium", Color.valueOf("7F8A91FF")) {{
            gas = true;
        }};
    }
}
