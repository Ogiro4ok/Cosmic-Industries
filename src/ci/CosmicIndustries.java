package ci;

import arc.*;
import arc.util.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import ci.content.*;

public class CosmicIndustries extends Mod{

    public CosmicIndustries(){
        Log.info("Loaded CosmicIndustries constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("Null");
                dialog.cont.add("sus").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("null")).pad(40f).row();
                dialog.cont.button("OH NO", dialog::hide).size(300f, 60f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){

        Log.info("Loading some ci content.");

        CosmicIndustriesItems.load();
        CosmicIndustriesLiquids.load();
        CosmicIndustriesUnits.load();
        CosmicIndustriesBlocks.load();
        CosmicIndustriesPlanets.load();
        CosmicIndustriesTechTree.load();
    }

}