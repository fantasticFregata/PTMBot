package me.fantasticFregata;

import java.util.HashMap;
import java.lang.Character;

public class CharacterEmojis {

	public static HashMap<String, String[]> characterEmojis = new HashMap<String, String[]>();

	public static String charToEmoji(String name) {

		name.toLowerCase();

		// creates a character of the last digit of the name (for example the 8 in
		// mario8)
		Character lastDigit = Character.valueOf(name.charAt(name.length() - 1));

		// returns the inputted string unchanged if the name is in the hashmap
		// or if the last digit is not a number
		// or if the number is larger than 8 or less than 2
		if (!CharacterEmojis.characterEmojis.containsKey(name) && (!Character.isDigit(lastDigit)
				|| Integer.parseInt(lastDigit.toString()) > 8 || Integer.parseInt(lastDigit.toString()) < 2)) {
			return "CHARNOTFOUND";
		}

		// if the name without the number at the end is in the hashmap...
		if (CharacterEmojis.characterEmojis.containsKey(name.substring(0, name.length() - 1))) {
			// ...then return that name plus the last digit (minus 1) as its index in the
			// corresponding array
			return CharacterEmojis.characterEmojis
					.get(name.substring(0, name.length() - 1))[Integer.parseInt(lastDigit.toString()) - 1];
			// else if the name by itself is in the hashmap (i.e. "mario")
		} else if (CharacterEmojis.characterEmojis.containsKey(name)) {
			// ...then return the first String in the corresponding array from the hashmap
			return CharacterEmojis.characterEmojis.get(name)[0];
		} else {
			// if it's none of those things, then return the inputted string unchanged
			System.out.println("char not there");
			return name;
		}
	}

	static {
		// Putting alts in string arrays for their characters
		String[] bayonetta = { "<:bayonetta:575804398215757854>", "<:bayonetta2:609627104400637952>",
				"<:bayonetta3:617456937654812691>", "<:bayonetta4:617456938099146763>",
				"<:bayonetta5:617456938464182283>", "<:bayonetta6:617456938346872832>",
				"<:bayonetta7:617456938602463253>", "<:bayonetta8:617456938485153849>" };

		String[] bowser_jr = { "<:bowser_jr:575804398186528768>", "<:Roy:916829232011804792>",
				"<:larry:609627242124804116>", "<:wendy:609627242313678860>", "<:iggy:609627242183655434>",
				"<:morton:609627242066345994>", "<:lemmy:609627242309353472>", "<:ludwig:609627242422599681>" };

		String[] bowser = { "<:bowser:575804398123352104>", "<:bowser2:617457148229713925>",
				"<:bowser3:617457148263137283>", "<:bowser4:617457148737093655>", "<:bowser5:617457148569452547>",
				"<:bowser6:617457148351217675>", "<:bowser7:617457148527509578>", "<:bowser8:617457148732899437>" };

		String[] captain_falcon = { "<:captain_falcon:575804398425604116>", "<:captain_falcon2:617457329868374027>",
				"<:captain_falcon3:617457329901666314>", "<:captain_falcon4:617457329566122006>",
				"<:captain_falcon5:617457329616584816>", "<:captain_falcon6:617457330396594205>",
				"<:captain_falcon7:617457330044534786>", "<:captain_falcon8:617457330363039761>" };

		String[] chrom = { "<:chrom:575804398521810994>", "<:chrom2:617457700711956481>",
				"<:chrom3:617457700913283082>", "<:chrom4:617457700867145788>", "<:chrom5:617457700762026014>",
				"<:chrom6:617457700380475413>", "<:chrom7:617457700883922944>", "<:chrom8:617457702477496320>" };

		String[] cloud = { "<:clouds:575804398496776192>", "<:cloud2:609627410693881887>",
				"<:cloud3:617457884586049539>", "<:cloud4:617457882988019742>", "<:cloud5:617457883281490079>",
				"<:cloud6:617457883386347629>", "<:cloud7:617457883130363924>", "<:cloud8:617457883952709652>" };

		String[] corrin = { "<:corrin:575804398530330634>", "<:corrin2:609627646518624266>",
				"<:corrin3:617458018824749086>", "<:corrin4:617458018694594601>", "<:corrin5:617458018996584532>",
				"<:corrin6:617458019038658571>", "<:corrin7:617458616185782281>", "<:corrin8:617458615812489252>" };

		String[] daisy = { "<:daisy:575804398677262346>", "<:daisy2:617458685790388290>",
				"<:daisy3:617458685647650837>", "<:daisy4:617458685433741390>", "<:daisy5:617458685723148324>",
				"<:daisy6:617458685848977408>", "<:daisy7:617458685949509738>", "<:daisy8:617458686087921722>" };

		String[] dark_pit = { "<:dark_pit:575804398718943243>", "<:dark_pit2:617459327116247070>",
				"<:dark_pit3:617459327627689990>", "<:dark_pit4:617459326990155777>", "<:dark_pit5:617459327518769152>",
				"<:dark_pit6:617459327355322399>", "<:dark_pit7:617459327606980628>",
				"<:dark_pit8:617459327405654049>" };

		String[] dark_samus = { "<:dark_samus:575804398786314240>", "<:dark_samus2:617459475745603614>",
				"<:dark_samus3:617459475560923157>", "<:dark_samus4:617459475506397228>",
				"<:dark_samus5:617459476051656738>", "<:dark_samus6:617459476047462466>",
				"<:dark_samus7:617459476051656770>", "<:dark_samus8:617459475938279464>" };

		String[] diddy_kong = { "<:diddy_kong:575804398413021219>", "<:diddy_kong2:617459636353892432>",
				"<:diddy_kong3:617459636269744166>", "<:diddy_kong4:617459636408418364>",
				"<:diddy_kong5:617459636307755018>", "<:diddy_kong6:617459636315881473>",
				"<:diddy_kong7:617459636802682890>", "<:diddy_kong8:617459636500562001>" };

		String[] donkey_kong = { "<:donkey_kong:575804398631124993>", "<:donkey_kong2:617459850225385472>",
				"<:donkey_kong3:617459850594615310>", "<:donkey_kong4:617459851941117971>",
				"<:donkey_kong5:617459850657529999>", "<:donkey_kong6:617459850435100672>",
				"<:donkey_kong7:617459850594615433>", "<:donkey_kong8:617459851588665408>" };

		String[] mii_gunner = { "<:mii_gunner:596831773556736000>", "<:mii_gunner:596831773556736000>",
				"<:mii_gunner:596831773556736000>", "<:mii_gunner:596831773556736000>",
				"<:mii_gunner:596831773556736000>", "<:mii_gunner:596831773556736000>",
				"<:mii_gunner:596831773556736000>", "<:mii_gunner:596831773556736000>" };

		String[] mii_brawler = { "<:mii_brawler:596831773338632202>", "<:mii_brawler:596831773338632202>",
				"<:mii_brawler:596831773338632202>", "<:mii_brawler:596831773338632202>",
				"<:mii_brawler:596831773338632202>", "<:mii_brawler:596831773338632202>",
				"<:mii_brawler:596831773338632202>", "<:mii_brawler:596831773338632202>" };

		String[] mii_swordfighter = { "<:mii_swordfighter:596831773535764527>",
				"<:mii_swordfighter:596831773535764527>", "<:mii_swordfighter:596831773535764527>",
				"<:mii_swordfighter:596831773535764527>", "<:mii_swordfighter:596831773535764527>",
				"<:mii_swordfighter:596831773535764527>", "<:mii_swordfighter:596831773535764527>",
				"<:mii_swordfighter:596831773535764527>" };

		String[] dr_mario = { "<:dr_mario:575804398865743879>", "<:dr_mario2:617459997621878792>",
				"<:dr_mario3:617459997194059777>", "<:dr_mario4:617459997323952130>", "<:dr_mario5:617459997823205396>",
				"<:dr_mario6:617459997818880069>", "<:dr_mario7:617459997663559811>",
				"<:dr_mario8:617459997835657257>" };

		String[] duck_hunt = { "<:duck_hunt:575804398962475029>", "<:duck_hunt2:617460256192200892>",
				"<:duck_hunt3:617460256196395057>", "<:duck_hunt4:617460256196395217>",
				"<:duck_hunt5:617460256192069646>", "<:duck_hunt6:617460255865176086>",
				"<:duck_hunt7:617460256326418442>", "<:duck_hunt8:617460564767277075>" };

		String[] falco = { "<:falco:575804399142567936>", "<:falco2:617460773316460602>",
				"<:falco3:617460772934516784>", "<:falco4:617460773089968139>", "<:falco5:617460772271947807>",
				"<:falco6:617460772364222519>", "<:falco7:617460773874040902>", "<:falco8:617460773559730196>" };

		String[] fox = { "<:foxs:575804399096561664>", "<:fox2:617461013406679081>", "<:fox3:617461013121335324>",
				"<:fox4:617461013721120784>", "<:fox5:617461013293432836>", "<:fox6:617461013675245572>",
				"<:fox7:617461013897412644>", "<:fox8:617461013633171467>" };

		String[] ganondorf = { "<:ganondorf:575804399348088833>", "<:ganondorf2:617461206680076392>",
				"<:ganondorf3:617461206713892904>", "<:ganondorf4:617461206713761812>",
				"<:ganondorf5:617461206684270698>", "<:ganondorf6:617461206835265536>",
				"<:ganondorf7:617461206675882059>", "<:ganondorf8:617461206571286579>" };

		String[] greninja = { "<:greninja:575804399276916756>", "<:greninja2:617461360317563009>",
				"<:greninja3:617461360850108416>", "<:greninja4:617461360455843846>", "<:greninja5:617461360892051564>",
				"<:greninja6:617461360850370581>", "<:greninja7:617461361005297724>",
				"<:greninja8:617461360636329995>" };

		String[] ice_climbers = { "<:ice_climbers:575804399339700234>", "<:ice_climbers2:617461657719013379>",
				"<:ice_climbers3:617461658184318976>", "<:ice_climbers4:617461658238976000>",
				"<:ice_climbers5:617461658142507040>", "<:ice_climbers6:617461658104889364>",
				"<:ice_climbers7:617461658243170364>", "<:ice_climbers8:617461659681816580>" };

		String[] ike = { "<:ike:575804399377711115>", "<:ike2:617461924137009172>", "<:ike3:617461924212506624>",
				"<:ike4:617461924464033837>", "<:ike5:617461924191535145>", "<:ike6:617461924464033828>",
				"<:ike7:617461924183146507>", "<:ike8:617461924417765386>" };

		String[] incineroar = { "<:incineroar:575804399272722432>", "<:incineroar2:617462115686547472>",
				"<:incineroar3:617462116349247499>", "<:incineroar4:617462116193927228>",
				"<:incineroar5:617462532793303110>", "<:incineroar6:617462532621336578>",
				"<:incineroar7:617462532478599168>", "<:incineroar8:617462535070679053>" };

		String[] inkling = { "<:inkling:575804399549415424>", "<:inkling2:617462853787582495>",
				"<:inkling3:617462853968068611>", "<:inkling4:617462853733056730>", "<:inkling5:617462854156812307>",
				"<:inkling6:617462853825331340>", "<:inkling7:617462854341099521>", "<:inkling8:617462854312001547>" };

		String[] isabelle = { "<:isabelle:575804745453797396>", "<:isabelle2:617463338405724172>",
				"<:isabelle3:617463338028236805>", "<:isabelle4:617463338405724169>", "<:isabelle5:617463338355654666>",
				"<:isabelle6:617463338405724187>", "<:isabelle7:617463338405724161>",
				"<:isabelle8:617463338590535696>" };

		String[] jigglypuff = { "<:jigglypuff:575804399545483264>", "<:jigglypuff2:617463663938502677>",
				"<:jigglypuff3:617463663896297498>", "<:jigglypuff4:617463663783313428>",
				"<:jigglypuff5:617463663799828515>", "<:jigglypuff6:617463664013737984>",
				"<:jigglypuff7:617463663833382922>", "<:jigglypuff8:617463663858548746>" };

		String[] joker = { "<:joker:575804399742484500>", "<:joker2:617463820431917080>",
				"<:joker3:617463820180258856>", "<:joker4:617463820415139862>", "<:joker5:617463821170376714>",
				"<:joker6:617463820482248704>", "<:joker7:609628737461289014>", "<:joker8:617463820784238659>" };

		String[] ken = { "<:ken:575804400195469331>", "<:ken2:617463934290755598>", "<:ken3:617463934173315082>",
				"<:ken4:617463934227841026>", "<:ken5:617463933858611233>", "<:ken6:617463934407933964>",
				"<:ken7:617463934026252447>", "<:ken8:617463934416322560>" };

		String[] king_dedede = { "<:king_dedede:575804399847211052>", "<:king_dedede2:617464064947519490>",
				"<:king_dedede3:617464065232601088>", "<:king_dedede4:617464065056440323>",
				"<:king_dedede5:617464065366687746>", "<:king_dedede6:617464064964296704>",
				"<:king_dedede7:617464425594748948>", "<:king_dedede8:617464425451880458>" };

		String[] king_k_rool = { "<:king_k_rool:575804399830564894>", "<:king_k_rool2:617464909378355220>",
				"<:king_k_rool3:617464909382549532>", "<:king_k_rool4:617464909059457037>",
				"<:king_k_rool5:617464909273366549>", "<:king_k_rool6:617464909483212832>",
				"<:king_k_rool7:617464909743128576>", "<:king_k_rool8:617464909482950676>" };

		String[] kirby = { "<:kirby:575804399587164190>", "<:kirby2:617465052852912149>",
				"<:kirby3:617465052823552021>", "<:kirby4:617465052886204473>", "<:kirby5:617465052873883680>",
				"<:kirby6:617465052689334293>", "<:kirby7:617465053108502558>", "<:kirby8:617465053201039420>" };

		String[] link = { "<:links:575804400056926250>", "<:link2:617465211070447626>", "<:link3:617465210923516064>",
				"<:link4:617465210952876123>", "<:link5:617465211057864719>", "<:link6:617465210906738844>",
				"<:link7:617465210923515948>", "<:link8:617465211774959621>" };

		String[] little_mac = { "<:little_mac:575804400099131394>", "<:little_mac2:617465449793323049>",
				"<:little_mac3:617465449705111573>", "<:little_mac4:617465450053500948>",
				"<:little_mac5:617465449864626177>", "<:little_mac6:617465449986261002>",
				"<:little_mac7:617465450066083870>", "<:little_mac8:617465450078666772>" };

		String[] lucario = { "<:lucario:575804400136880142>", "<:lucario2:617465602168193035>",
				"<:lucario3:617465602507800647>", "<:lucario4:617465602684223489>", "<:lucario5:617465602147221505>",
				"<:lucario6:617465604118675476>", "<:lucario7:617465602654601256>", "<:lucario8:617465602658795527>" };

		String[] lucas = { "<:lucas:575804400023371776>", "<:lucas2:617465732669898764>",
				"<:lucas3:617465733361696778>", "<:lucas4:617465732959174758>", "<:lucas5:617465732548001808>",
				"<:lucas6:617465733236129792>", "<:lucas7:617465733093523456>", "<:lucas8:617465733320015912>" };

		String[] lucina = { "<:lucina:575804400208052244>", "<:lucina2:617465856389021712>",
				"<:lucina3:617465856682754073>", "<:lucina4:617465856514850838>", "<:lucina5:617465856682754225>",
				"<:lucina6:617465856703725755>", "<:lucina7:617465856691142775>", "<:lucina8:617466622617321486>" };

		String[] luigi = { "<:luigi:575804401130799130>", "<:luigi2:617466677671493672>",
				"<:luigi3:617466677767962654>", "<:luigi4:617466677705310268>", "<:luigi5:617466677658910726>",
				"<:luigi6:617466677789065233>", "<:luigi7:617466677768093780>", "<:luigi8:617466677675819162>" };

		String[] mario = { "<:mario:575804400140943381>", "<:mario2:617466808974311463>",
				"<:mario3:617466810027212805>", "<:mario4:617466808957534209>", "<:mario5:617466809959841814>",
				"<:mario6:617466810236665872>", "<:mario7:617466809045745674>", "<:mario8:617466808890425356>" };

		String[] marth = { "<:marth:575804400157589546>", "<:marth2:617466924431048737>",
				"<:marth3:617466924430917686>", "<:marth4:617466924800147466>", "<:marth5:617466924023939073>",
				"<:marth6:617466924271534091>", "<:marth7:617466924091047937>", "<:marth8:617466924493963294>" };

		String[] mega_man = { "<:mega_man:575804482064089089>", "<:mega_man2:617467054005682187>",
				"<:mega_man3:617467054211072031>", "<:mega_man4:617467053976059944>", "<:mega_man5:617467054156546185>",
				"<:mega_man6:617467054177648679>", "<:mega_man7:617467054122991715>",
				"<:mega_man8:617467054248820766>" };

		String[] meta_knight = { "<:meta_knight:575804482084929546>", "<:meta_knight2:617467171357851678>",
				"<:meta_knight3:617467171144204309>", "<:meta_knight4:617467171542532102>",
				"<:meta_knight5:617467171349463040>", "<:meta_knight6:617467171026632705>",
				"<:meta_knight7:617467171232022529>", "<:meta_knight8:617467171437543424>" };

		String[] mewtwo = { "<:mewtwo:575804482198175763>", "<:mewtwo2:617467314622693383>",
				"<:mewtwo3:617467314366840863>", "<:mewtwo4:617467314740133956>", "<:mewtwo5:617467314673287189>",
				"<:mewtwo6:617467315059163146>", "<:mewtwo7:617467314929139772>", "<:mewtwo8:617467315184861199>" };

		String[] mr_game_and_watch = { "<:mr_game_and_watch:575804481980071939>",
				"<:mr_game_and_watch2:617467427386687511>", "<:mr_game_and_watch3:617467427160064030>",
				"<:mr_game_and_watch4:617467427315515438>", "<:mr_game_and_watch5:617467427470442516>",
				"<:mr_game_and_watch6:617467426946154553>", "<:mr_game_and_watch7:617467427348807729>",
				"<:mr_game_and_watch8:617467427407659037>" };

		String[] ness = { "<:ness:575804482642771994>", "<:ness2:617468346593443841>", "<:ness3:617468346669203476>",
				"<:ness4:617468346694369290>", "<:ness5:617468346601832448>", "<:ness6:617468346673135616>",
				"<:ness7:617468346530660385>", "<:ness8:617468346983645196>" };

		String[] olimar = { "<:olimar:575804482756018196>", "<:olimar2:617468469427830840>",
				"<:olimar3:617468469084028929>", "<:olimar4:617468469490745363>", "<:alph5:617468469117583389>",
				"<:alph6:617468469881077760>", "<:alph7:617468469687877652>", "<:alph8:609627043679830016>" };

		String[] pac_man = { "<:pac_man:575804482148106276>", "<:pac_man2:617468698621509777>",
				"<:pac_man3:617468699451981838>", "<:pac_man4:617468698965311500>", "<:pac_man5:617468699171094578>",
				"<:pac_man6:617468699229814804>", "<:pac_man7:617468699204648961>", "<:pac_man8:617468699389198354>" };

		String[] palutena = { "<:palutena:575804482387050560>", "<:palutena2:617468832814202900>",
				"<:palutena3:617468832964935693>", "<:palutena4:617468832784711681>", "<:palutena5:617468832503693356>",
				"<:palutena6:617468832868597761>", "<:palutena7:617468833338228736>",
				"<:palutena8:617468832906346496>" };

		String[] peach = { "<:peachs:575804482852618265>", "<:peach2:617469305629573141>",
				"<:peach3:617469305721978890>", "<:peach4:617469305671647292>", "<:peach5:617469305734561793>",
				"<:peach6:617469305826705449>", "<:peach7:617469305382240288>", "<:peach8:617469305847545883>" };

		String[] pichu = { "<:pichu:575804482353364993>", "<:pichu2:617469428153450509>",
				"<:pichu3:617469428204044298>", "<:pichu4:617469428291993620>", "<:pichu5:617469428015300609>",
				"<:pichu6:617469428216365075>", "<:pichu7:617469428317159434>", "<:pichu8:617469428354908160>" };

		String[] pikachu = { "<:pikachu:575804744040185894>", "<:pikachu2:617469846401318932>",
				"<:pikachu3:617469846141272085>", "<:pikachu4:617469846182953002>", "<:pikachu5:617469846204186646>",
				"<:pikachu6:617469846267101186>", "<:pikachu7:617469846614966288>", "<:pikachu8:617469846719954999>" };

		String[] piranha_plant = { "<:piranha_plant:595042549887139840>", "<:piranha_plant2:617470392767873044>",
				"<:piranha_plant3:617470392797495326>", "<:piranha_plant4:617470877189013525>",
				"<:piranha_plant5:617470875922595850>", "<:piranha_plant6:617470875993899018>",
				"<:piranha_plant7:617470875700035595>", "<:piranha_plant8:617470875637252117>" };

		String[] pit = { "<:pit:575804744476393502>", "<:pit2:617471216089038885>", "<:pit3:617471216130981933>",
				"<:pit4:617471217409982754>", "<:pit5:617471216449617938>", "<:pit6:617471216068067355>",
				"<:pit7:617471216693018634>", "<:pit8:617471216231514114>" };

		String[] pokemon_trainer = { "<:pokemon_trainer:575804744849948674>", "<:pokemon_trainer2:609628464735059993>",
				"<:pokemon_trainer3:617471330375434250>", "<:pokemon_trainer4:617471330484486154>",
				"<:pokemon_trainer5:617471330391949312>", "<:pokemon_trainer6:617471330304131096>",
				"<:pokemon_trainer7:617471330278834199>", "<:pokemon_trainer8:617471330673229824>" };

		String[] richter = { "<:richter:575804744510078976>", "<:richter2:617471452769157120>",
				"<:richter3:617471451490025472>", "<:richter4:617471451641151518>", "<:richter5:617471451833958489>",
				"<:richter6:617471451527905292>", "<:richter7:617471451842347034>", "<:richter8:617471451842215966>" };

		String[] ridley = { "<:ridley:575804744996487168>", "<:ridley2:617471572604878869>",
				"<:ridley3:617471572709736468>", "<:ridley4:617471572101562419>", "<:ridley5:617471572466335747>",
				"<:ridley6:617471572004831267>", "<:ridley7:617471572743290885>", "<:ridley8:617471572588101672>" };

		String[] robin = { "<:robin:575804744707211284>", "<:robin2:609627731428114442>",
				"<:robin3:617471777358086197>", "<:robin4:617471777274200099>", "<:robin5:617471777546960906>",
				"<:robin6:617471777236451334>", "<:robin7:617471777945288738>", "<:robin8:617471777823784970>" };

		String[] rob = { "<:rob:575804744363409409>", "<:rob2:617471670290087980>", "<:rob3:617471670168322079>",
				"<:rob4:617471670386425961>", "<:rob5:617471670386556930>", "<:rob6:617471670428499988>",
				"<:rob7:617471670256664589>", "<:rob8:617471670487089152>" };

		String[] rosalina_and_luma = { "<:rosalina_and_luma:575804744917057577>",
				"<:rosalina_and_luma2:617471876775542785>", "<:rosalina_and_luma3:617471877069275156>",
				"<:rosalina_and_luma4:617471877077663797>", "<:rosalina_and_luma5:617471877144772641>",
				"<:rosalina_and_luma6:617472121811238923>", "<:rosalina_and_luma7:617472397276348427>",
				"<:rosalina_and_luma8:617472397095731253>" };

		String[] roy = { "<:roy:575804744891891714>", "<:roy2:617472741141905483>", "<:roy3:617472741024727062>",
				"<:roy4:617472741020401669>", "<:roy5:617472741154750474>", "<:roy6:617472741066670120>",
				"<:roy7:617472741179654219>", "<:roy8:617472741141905527>" };

		String[] ryu = { "<:ryu:575804745005006868>", "<:ryu2:617472838885965854>", "<:ryu3:617472839095812203>",
				"<:ryu4:617472839095812138>", "<:ryu5:617472839007600640>", "<:ryu6:617472839251132428>",
				"<:ryu7:617472839183892481>", "<:ryu8:617472839217446973>" };

		String[] samus = { "<:samus:575804744959000577>", "<:samus2:617472947111723239>",
				"<:samus3:617472947040288788>", "<:samus4:617472947103334502>", "<:samus5:617472946771984427>",
				"<:samus6:617472947128500293>", "<:samus7:617472947153797120>", "<:samus8:617472946914721803>" };

		String[] sheik = { "<:sheik:575804745193881610>", "<:sheik2:617473060681023513>",
				"<:sheik3:617473060546674692>", "<:sheik4:617473060802658334>", "<:sheik5:617473060735549450>",
				"<:sheik6:617473060777492502>", "<:sheik7:617473060647337986>", "<:sheik8:617473061402312737>" };

		String[] shulk = { "<:shulk:575804745302671399>", "<:shulk2:617473172174012454>",
				"<:shulk3:617473172476002324>", "<:shulk4:617473172517945365>", "<:shulk5:617473172551368815>",
				"<:shulk6:617473172685717544>", "<:shulk7:617473172731592715>", "<:shulk8:617473172849164310>" };

		String[] simon = { "<:simon:575804745340420126>", "<:simon2:617473278964924437>",
				"<:simon3:617473279069913099>", "<:simon4:617473279493537829>", "<:simon5:617473279434948608>",
				"<:simon6:617473280558891087>", "<:simon7:617473280466485269>", "<:simon8:617473280676331559>" };

		String[] snake = { "<:snakes:575804746561093632>", "<:snake2:617473388646105092>",
				"<:snake3:617473387941331060>", "<:snake4:617473388159696916>", "<:snake5:617473387706449922>",
				"<:snake6:617473388205572126>", "<:snake7:617473388679659553>", "<:snake8:617474084246126687>" };

		String[] sonic = { "<:sonic:575804745462317071>", "<:sonic2:617474213619433482>",
				"<:sonic3:617474213904908308>", "<:sonic4:617474213778948174>", "<:sonic5:617474213799919628>",
				"<:sonic6:617474213594529813>", "<:sonic7:617474213787467776>", "<:sonic8:617474213862965259>" };

		String[] toon_link = { "<:toon_link:575804745760112650>", "<:toon_link2:617474415122317394>",
				"<:toon_link3:617474415130705978>", "<:toon_link4:617474415285895170>",
				"<:toon_link5:617474415667445774>", "<:toon_link6:617474415462055960>",
				"<:toon_link7:617474417043177493>", "<:toon_link8:617474415759982612>" };

		String[] villager = { "<:villager:575804745558655016>", "<:villager2:617474539626168323>",
				"<:villager3:617474539185635486>", "<:villager4:617474540213239860>", "<:villager5:617474540146262016>",
				"<:villager6:617474540129353863>", "<:villager7:617474540280348783>",
				"<:villager8:617474540007849985>" };

		String[] wario = { "<:wario:575804745520906260>", "<:wario2:609627866719584262>",
				"<:wario3:617474699592597659>", "<:wario4:617474699290738689>", "<:wario5:617474699684872312>",
				"<:wario6:617474700314017852>", "<:wario7:617474699835736095>", "<:wario8:617474699789860877>" };

		String[] wii_fit_trainer = { "<:wii_fit_trainer:575804745654992906>", "<:wii_fit_trainer2:609628293934874655>",
				"<:wii_fit_trainer3:617474820350935070>", "<:wii_fit_trainer4:617474820367450245>",
				"<:wii_fit_trainer5:617474820375969792>", "<:wii_fit_trainer6:617474820409655316>",
				"<:wii_fit_trainer7:617474820061397025>", "<:wii_fit_trainer8:617474820921229321>" };

		String[] wolf = { "<:wolfs:575804745797599252>", "<:wolf2:617474938995081247>", "<:wolf3:617474938839891969>",
				"<:wolf4:617474938802143252>", "<:wolf5:617474938831634444>", "<:wolf6:617474938516799489>",
				"<:wolf7:617474938642890753>", "<:wolf8:617474938718257179>" };

		String[] yoshi = { "<:yoshi:575804745734946816>", "<:yoshi2:617475036072247432>",
				"<:yoshi3:617475035971715083>", "<:yoshi4:617475476163657758>", "<:yoshi5:617475476755054808>",
				"<:yoshi6:617475476264452157>", "<:yoshi7:617475475853279386>", "<:yoshi8:617475475819724869>" };

		String[] young_link = { "<:young_link:575804746091462688>", "<:young_link2:617475580040052777>",
				"<:young_link3:617475580522135570>", "<:young_link4:617475580484648961>",
				"<:young_link5:617475580010430527>", "<:young_link6:617475580400762880>",
				"<:young_link7:617475580560015424>", "<:young_link8:617475580652290067>" };

		String[] zelda = { "<:zelda:575804745877553182>", "<:zelda2:617475705189564477>",
				"<:zelda3:617475705495879690>", "<:zelda4:617475705910984705>", "<:zelda5:617475705873367060>",
				"<:zelda6:617475705705332791>", "<:zelda7:617475705696944201>", "<:zelda8:617475705759858740>" };

		String[] zero_suit_samus = { "<:zero_suit_samus:575804746124886016>", "<:zero_suit_samus2:617475824915841075>",
				"<:zero_suit_samus3:617475825444454405>", "<:zero_suit_samus4:617475825419288584>",
				"<:zero_suit_samus5:617475824945201165>", "<:zero_suit_samus6:617475825109041163>",
				"<:zero_suit_samus7:617475825415225345>", "<:zero_suit_samus8:617475824991338508>" };

		String[] hero = { "<:hero:596831646842486805>", "<:hero2:738133349360467979>", "<:hero3:609630913776582656>",
				"<:hero4:609630913470660609>", "<:hero5:617461527053729963>", "<:hero6:738133249305346181>",
				"<:hero7:617461527095803934>", "<:hero8:617461526835757057>" };

		String[] banjo_and_kazooie = { "<:banjo_and_kazooie:596831625765978131>",
				"<:banjo_and_kazooie2:620744650608869376>", "<:banjo_and_kazooie3:620744650986094592>",
				"<:banjo_and_kazooie4:620744651774754839>", "<:banjo_and_kazooie5:620744651954978848>",
				"<:banjo_and_kazooie6:620744652005572628>", "<:banjo_and_kazooie7:620744651996921856>",
				"<:banjo_and_kazooie8:620744652009766922>" };

		String[] terry = { "<:terry:641715693225639953>", "<:terry2:642203341589577738>",
				"<:terry3:642203341585121292>", "<:terry4:642203341664813056>", "<:terry5:642203341769670676>",
				"<:terry6:642203341794967594>", "<:terry7:642203341878853642>", "<:terry8:642203342017265683>" };

		String[] byleth = { "<:byleth:672630558886461460>", "<:byleth2:672629809293033484>",
				"<:byleth3:672629809582440449>", "<:byleth4:672629809624383488>", "<:byleth5:672629809603674122>",
				"<:byleth6:672629809704337418>", "<:byleth7:672629809557536789>", "<:byleth8:672629809679040542>" };

		String[] min_min = { "<:min_min:728013949865558046>", "<:min_min2:728013949580345386>",
				"<:min_min3:728013949475487837>", "<:min_min4:728013949806706840>", "<:min_min5:728013949609705503>",
				"<:min_min6:728013949819158559>", "<:min_min7:728013949865427105>", "<:min_min8:728013949512974389>" };

		String[] steve = { "<:steve:766121990519914517>", "<:alex2:766121990448742401>", "<:steve3:766121990385041459>",
				"<:alex4:766121990691487784>", "<:steve5:766121990439960588>", "<:alex6:766121990456344596>",
				"<:zombie7:766121990485966928>", "<:enderman8:766121990595411978>" };

		String[] sephiroth = { "<:sephiroth:788644412296003594>", "<:sephiroth2:790035634499747881>",
				"<:sephiroth3:790035634064195606>", "<:sephiroth4:790035634198544426>",
				"<:sephiroth5:790035634332368896>", "<:sephiroth6:790035634718900224>",
				"<:sephiroth7:790035634379161610>", "<:sephiroth8:790035634651136030>" };

		String[] pyra_and_mythra = { "<:pythra:817865907912048641>", "<:pythra2:817865908219150397>",
				"<:pythra3:817865908281540668>", "<:pythra4:817865908399767573>", "<:pythra5:817865908298579988>",
				"<:pythra6:817865908444856330>", "<:pythra7:817866846543282208>", "<:pythra8:817866846543675424>" };

		String[] kazuya = { "<:kazuya:861697760163659806>", "<:kazuya2:861697759844106271>",
				"<:kazuya3:861697759895617537>", "<:kazuya4:861697760411385856>", "<:kazuya5:861697760029573131>",
				"<:kazuya6:861697760029573132>", "<:kazuya7:861697760036913195>", "<:kazuya8:861697760315179088>" };

		String[] sora = { "<:sora:900465845099200512>", "<:sora2:900465845132754944>", "<:sora3:900465844742668320>",
				"<:sora4:900465844902051851>", "<:sora5:900465845120139274>", "<:sora6:900465845128532090>",
				"<:sora7:900465845149503528>", "<:sora8:900465844755243009>" };

		// adding string arrays to HashMap
		characterEmojis.put("bayonetta", bayonetta);
		characterEmojis.put("bayo", bayonetta);
		characterEmojis.put("bowser jr", bowser_jr);
		characterEmojis.put("bjr", bowser_jr);
		characterEmojis.put("larry", bowser_jr);
		characterEmojis.put("morton", bowser_jr);
		characterEmojis.put("wendy", bowser_jr);
		characterEmojis.put("iggy", bowser_jr);
		characterEmojis.put("lemmy", bowser_jr);
		characterEmojis.put("ludwig", bowser_jr);
		characterEmojis.put("bowser", bowser);
		characterEmojis.put("captain falcon", captain_falcon);
		characterEmojis.put("falcon", captain_falcon);
		characterEmojis.put("chrom", chrom);
		characterEmojis.put("cloud", cloud);
		characterEmojis.put("corrin", corrin);
		characterEmojis.put("daisy", daisy);
		characterEmojis.put("dark pit", dark_pit);
		characterEmojis.put("dpit", dark_pit);
		characterEmojis.put("pittoo", dark_pit);
		characterEmojis.put("dark samus", dark_samus);
		characterEmojis.put("dsamus", dark_samus);
		characterEmojis.put("diddy kong", diddy_kong);
		characterEmojis.put("diddy", diddy_kong);
		characterEmojis.put("donkey kong", donkey_kong);
		characterEmojis.put("dk", donkey_kong);
		characterEmojis.put("mii gunner", mii_gunner);
		characterEmojis.put("gunner", mii_gunner);
		characterEmojis.put("mii brawler", mii_brawler);
		characterEmojis.put("brawler", mii_brawler);
		characterEmojis.put("mii swordfighter", mii_swordfighter);
		characterEmojis.put("msf", mii_swordfighter);
		characterEmojis.put("doctor mario", dr_mario);
		characterEmojis.put("dr mario", dr_mario);
		characterEmojis.put("doc", dr_mario);
		characterEmojis.put("duck hunt", duck_hunt);
		characterEmojis.put("duck hunt duo", duck_hunt);
		characterEmojis.put("dhd", duck_hunt);
		characterEmojis.put("dh", duck_hunt);
		characterEmojis.put("falco", falco);
		characterEmojis.put("fox", fox);
		characterEmojis.put("ganondorf", ganondorf);
		characterEmojis.put("ganon", ganondorf);
		characterEmojis.put("greninja", greninja);
		characterEmojis.put("gren", greninja);
		characterEmojis.put("ice climbers", ice_climbers);
		characterEmojis.put("ics", ice_climbers);
		characterEmojis.put("icies", ice_climbers);
		characterEmojis.put("ike", ike);
		characterEmojis.put("incineroar", incineroar);
		characterEmojis.put("incin", incineroar);
		characterEmojis.put("inkling", inkling);
		characterEmojis.put("ink", inkling);
		characterEmojis.put("isabelle", isabelle);
		characterEmojis.put("isa", isabelle);
		characterEmojis.put("jigglypuff", jigglypuff);
		characterEmojis.put("puff", jigglypuff);
		characterEmojis.put("joker", joker);
		characterEmojis.put("ken", ken);
		characterEmojis.put("king dedede", king_dedede);
		characterEmojis.put("dedede", king_dedede);
		characterEmojis.put("ddd", king_dedede);
		characterEmojis.put("king k rool", king_k_rool);
		characterEmojis.put("krool", king_k_rool);
		characterEmojis.put("kkr", king_k_rool);
		characterEmojis.put("kirby", kirby);
		characterEmojis.put("link", link);
		characterEmojis.put("little mac", little_mac);
		characterEmojis.put("mac", little_mac);
		characterEmojis.put("lucario", lucario);
		characterEmojis.put("lucas", lucas);
		characterEmojis.put("lucina", lucina);
		characterEmojis.put("luigi", luigi);
		characterEmojis.put("mario", mario);
		characterEmojis.put("marth", marth);
		characterEmojis.put("mega man", mega_man);
		characterEmojis.put("megaman", mega_man);
		characterEmojis.put("mm", mega_man);
		characterEmojis.put("meta knight", meta_knight);
		characterEmojis.put("metaknight", meta_knight);
		characterEmojis.put("mk", meta_knight);
		characterEmojis.put("mewtwo", mewtwo);
		characterEmojis.put("m2", mewtwo);
		characterEmojis.put("mr game and watch", mr_game_and_watch);
		characterEmojis.put("qame and watch", mr_game_and_watch);
		characterEmojis.put("gnw", mr_game_and_watch);
		characterEmojis.put("ness", ness);
		characterEmojis.put("olimar", olimar);
		characterEmojis.put("oli", olimar);
		characterEmojis.put("alph", olimar);
		characterEmojis.put("pac man", pac_man);
		characterEmojis.put("pac-man", pac_man);
		characterEmojis.put("pac", pac_man);
		characterEmojis.put("palutena", palutena);
		characterEmojis.put("palu", palutena);
		characterEmojis.put("peach", peach);
		characterEmojis.put("pichu", pichu);
		characterEmojis.put("pikachu", pikachu);
		characterEmojis.put("pika", pikachu);
		characterEmojis.put("piranha plant", piranha_plant);
		characterEmojis.put("plant", piranha_plant);
		characterEmojis.put("pit", pit);
		characterEmojis.put("pokemon trainer", pokemon_trainer);
		characterEmojis.put("pokémon trainer", pokemon_trainer);
		characterEmojis.put("squirtle", pokemon_trainer);
		characterEmojis.put("charizard", pokemon_trainer);
		characterEmojis.put("ivysaur", pokemon_trainer);
		characterEmojis.put("pt", pokemon_trainer);
		characterEmojis.put("richter", richter);
		characterEmojis.put("ridley", ridley);
		characterEmojis.put("robin", robin);
		characterEmojis.put("rob", rob);
		characterEmojis.put("rosalina and luma", rosalina_and_luma);
		characterEmojis.put("rosalina", rosalina_and_luma);
		characterEmojis.put("rosa", rosalina_and_luma);
		characterEmojis.put("roy", roy);
		characterEmojis.put("ryu", ryu);
		characterEmojis.put("samus", samus);
		characterEmojis.put("sheik", sheik);
		characterEmojis.put("shiek", sheik);
		characterEmojis.put("shulk", shulk);
		characterEmojis.put("simon", simon);
		characterEmojis.put("snake", snake);
		characterEmojis.put("sonic", sonic);
		characterEmojis.put("toon link", toon_link);
		characterEmojis.put("tink", toon_link);
		characterEmojis.put("villager", villager);
		characterEmojis.put("villy", villager);
		characterEmojis.put("wario", wario);
		characterEmojis.put("wii fit trainer", wii_fit_trainer);
		characterEmojis.put("wft", wii_fit_trainer);
		characterEmojis.put("wolf", wolf);
		characterEmojis.put("yoshi", yoshi);
		characterEmojis.put("young link", young_link);
		characterEmojis.put("yink", young_link);
		characterEmojis.put("zelda", zelda);
		characterEmojis.put("zero suit samus", zero_suit_samus);
		characterEmojis.put("zss", zero_suit_samus);
		characterEmojis.put("hero", hero);
		characterEmojis.put("banjo and kazooie", banjo_and_kazooie);
		characterEmojis.put("banjo", banjo_and_kazooie);
		characterEmojis.put("terry", terry);
		characterEmojis.put("byleth", byleth);
		characterEmojis.put("min min", min_min);
		characterEmojis.put("minmin", min_min);
		characterEmojis.put("steve", steve);
		characterEmojis.put("alex", steve);
		characterEmojis.put("zombie", steve);
		characterEmojis.put("enderman", steve);
		characterEmojis.put("sephiroth", sephiroth);
		characterEmojis.put("seph", sephiroth);
		characterEmojis.put("pyra and mythra", pyra_and_mythra);
		characterEmojis.put("pythra", pyra_and_mythra);
		characterEmojis.put("pyra", pyra_and_mythra);
		characterEmojis.put("mythra", pyra_and_mythra);
		characterEmojis.put("kazuya", kazuya);
		characterEmojis.put("kaz", kazuya);
		characterEmojis.put("sora", sora);
	}

}