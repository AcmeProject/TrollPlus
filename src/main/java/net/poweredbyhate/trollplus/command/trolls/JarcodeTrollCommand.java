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
            "i secretly love laxwashere",
            "Hi, it's Maratx!!!!!",
            "Love you all <3",
            "YOUR OS IS JUST A BOOTLOADER FOR EMACS, THE ONE TRUE OPERATING SYSTEM"
    };
    private final String[] rants = { "What the fuck did you just fucking say about me, you little bitch? I’ll have you know I graduated top of my class in the Navy Seals, and I’ve been involved in numerous secret raids on Al-Quaeda, and I have over 300 confirmed kills. I am trained in gorilla warfare and I’m the top sniper in the entire US armed forces. You are nothing to me but just another target. I will wipe you the fuck out with precision the likes of which has never been seen before on this Earth, mark my fucking words. You think you can get away with saying that shit to me over the Internet? Think again, fucker. As we speak I am contacting my secret network of spies across the USA and your IP is being traced right now so you better prepare for the storm, maggot. The storm that wipes out the pathetic little thing you call your life. You’re fucking dead, kid. I can be anywhere, anytime, and I can kill you in over seven hundred ways, and that’s just with my bare hands. Not only am I extensively trained in unarmed combat, but I have access to the entire arsenal of the United States Marine Corps and I will use it to its full extent to wipe your miserable ass off the face of the continent, you little shit. If only you could have known what unholy retribution your little “clever” comment was about to bring down upon you, maybe you would have held your fucking tongue. But you couldn’t, you didn’t, and now you’re paying the price, you goddamn idiot. I will shit fury all over you and you will drown in it. You’re fucking dead, kiddo.", "What in Davy Jones’ locker did ye just bark at me, ye scurvy bilgerat? I’ll have ye know I be the meanest cutthroat on the seven seas, and I’ve led numerous raids on fishing villages, and raped over 300 wenches. I be trained in hit-and-run pillaging and be the deadliest with a pistol of all the captains on the high seas. Ye be nothing to me but another source o’ swag. I’ll have yer guts for garters and keel haul ye like never been done before, hear me true. You think ye can hide behind your newfangled computing device? Think twice on that, scallywag. As we parley I be contacting my secret network o’ pirates across the sea and yer port is being tracked right now so ye better prepare for the typhoon, weevil. The kind o’ monsoon that’ll wipe ye off the map. You’re sharkbait, fool. I can sail anywhere, in any waters, and can kill ye in o’er seven hundred ways, and that be just with me hook and fist. Not only do I be top o’ the line with a cutlass, but I have an entire pirate fleet at my beck and call and I’ll damned sure use it all to wipe yer arse off o’ the world, ye dog. If only ye had had the foresight to know what devilish wrath your jibe was about to incur, ye might have belayed the comment. But ye couldn’t, ye didn’t, and now ye’ll pay the ultimate toll, you buffoon. I’ll shit fury all over ye and ye’ll drown in the depths o’ it. You’re fish food now.
", "What the fuck did you just fucking say about my gear, you little n00b? I’ll have you know I am a lvl 90 Undead Arcane Mage, and I’ve won so many PVP matches, and I have done raids on every 10 man heroic dungeon. I also have a fuckton of macros and I have a GS of 10K. You are nothing to me but just a lvl 12 gnome hunter. I will pwn the fuck out of you with Arcane Missiles the likes of which has never been seen before on Azeroth AND Outland, mark my fucking words. You think you can get away with saying that shit to me over raid? Think again, fucker. As we speak I am contacting my guild of mages and shamans across The Eastern Kingdoms and your character is being targeted right now so you better prepare for the ownage, n00b. The Arcane Barrage that wipes out the pathetic little thing you call your character. You’re fucking pwn’d, n00b. I can be anywhere, anytime, and I can kill you in over seven hundred ways, and that’s just with my secondary talent tree. Not only am I extensively trained in Arcane magic, but I have access to the entire arsenal of Fire magic and I will use it to its full extent to wipe your miserable neckbeard off the face of Azeroth, you little faggot. If only you could have known what unholy retribution your little “clever” comment was about to bring down upon you, maybe you would have held your fucking tongue. But you couldn’t, you didn’t, and now you’re getting debuffed, you goddamnn00b. I will shit Dragon’s Breath all over you and you will burn in it. You’re fucking pwn’d, faggot.
", "What the swag did you just fucking yolo about me, you little wayne? I’ll have you know I graduated top of my class in the SwagFags, and I’ve been involved in numerous Obey Records , and I have over 300 confirmed Swaggers. I am trained in wearing snapbacks and I’m the top poser in the entire Swagfag Army. You are nothing to me but just another No swag. I will swag you the fuck out with swagger the likes of which has never been seen before on this Earth, mark my fucking hashtags. You think you can get away with not taking pictures in the mirror over the Internet? Think again, fucker. As we speak I am contacting my mom, she has alot of swag, and your ratchet ass is being traced right now so you better prepare for the yolo, nikka. The yolo that wipes out the pathetic little thing you call your swag. You’re fucking dead, nikka. I can swag anywhere, anytime, and I can swag in over seven hundred ways, and that’s just with my baggy skinny jeans. Not only am I extensively trained in having plugs and snake bites, but I have access to the entire Hollister store. and I will use it to its full swaggness to wipe your miserable swag off the face of tumblr, you little Non trend follower. I will swag yolo all over you and you will swag in it. You’re fucking dead, nikka.
" };

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
        player.sendMessage(rants[random.nextInt(rants.length)]);
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
