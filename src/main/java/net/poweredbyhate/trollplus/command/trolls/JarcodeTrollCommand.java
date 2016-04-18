package net.poweredbyhate.trollplus.command.trolls;

import net.poweredbyhate.trollplus.TrollPlus;
import net.poweredbyhate.trollplus.command.CommandConsumer;
import net.poweredbyhate.trollplus.player.TrollPlayer;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

/**
 * Created by Lax on 4/18/2016.
 */
public class JarcodeTrollCommand extends CommandConsumer {

    private final String[] jarcodes = { // oh and + jarcode
            "install fucking gentoo you pleb",
            "use emacs you sack of shit",
            "this server doesn\'t support your software freedom",
            "emacs is the one true editor, emacs is love, emacs is life",
            "i secretly love laxwashere"
    };
    private final String rant = "What the fuck did you just fucking say about me, you little bitch? I’ll have you know I graduated top of my class in the Navy Seals, and I’ve been involved in numerous secret raids on Al-Quaeda, and I have over 300 confirmed kills. I am trained in gorilla warfare and I’m the top sniper in the entire US armed forces. You are nothing to me but just another target. I will wipe you the fuck out with precision the likes of which has never been seen before on this Earth, mark my fucking words. You think you can get away with saying that shit to me over the Internet? Think again, fucker. As we speak I am contacting my secret network of spies across the USA and your IP is being traced right now so you better prepare for the storm, maggot. The storm that wipes out the pathetic little thing you call your life. You’re fucking dead, kid. I can be anywhere, anytime, and I can kill you in over seven hundred ways, and that’s just with my bare hands. Not only am I extensively trained in unarmed combat, but I have access to the entire arsenal of the United States Marine Corps and I will use it to its full extent to wipe your miserable ass off the face of the continent, you little shit. If only you could have known what unholy retribution your little “clever” comment was about to bring down upon you, maybe you would have held your fucking tongue. But you couldn’t, you didn’t, and now you’re paying the price, you goddamn idiot. I will shit fury all over you and you will drown in it. You’re fucking dead, kiddo.";

    private final Random random;

    public JarcodeTrollCommand(TrollPlus plugin) {
        super(plugin);
        random = new Random();
    }

    @Override
    protected void onCommand(final TrollPlayer player, String label, String[] args) {
        if (!player.hasPermissionOrIsOp("trollplus.jarcode")) {
            noPermz(player);
            return;
        }
        player.sendMessage(rant);
        new BukkitRunnable() {
            @Override
            public void run() {
                player.sendMessage("oh and " + jarcodes[random.nextInt(jarcodes.length)]);
            }
        }.runTaskLater(plugin, 40);
    }

    @Override
    public String getCommand() {
        return "jarcode";
    }
}
