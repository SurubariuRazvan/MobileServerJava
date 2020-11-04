package com.mobile.services;

import com.mobile.domain.model.Game;
import com.mobile.domain.model.exceptions.GameNotFoundException;
import com.mobile.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;

//        addData();
    }

    private void addData() {
        gameRepository.save(new Game(0L,730,"Counter-Strike: Global Offensive","Valve, Hidden Path Entertainment",4290831,589655,"100,000,000 .. 200,000,000",0.0f));
        gameRepository.save(new Game(0L,570,"Dota 2","Valve",1171409,214456,"100,000,000 .. 200,000,000",0.0f));
        gameRepository.save(new Game(0L,440,"Team Fortress 2","Valve",675272,42552,"50,000,000 .. 100,000,000",0.0f));
        gameRepository.save(new Game(0L,578080,"PLAYERUNKNOWN'S BATTLEGROUNDS","PUBG Corporation",852614,731646,"50,000,000 .. 100,000,000",29.99f));
        gameRepository.save(new Game(0L,304930,"Unturned","Smartly Dressed Games",367700,36048,"20,000,000 .. 50,000,000",0.0f));
        gameRepository.save(new Game(0L,230410,"Warframe","Digital Extremes",355874,36279,"20,000,000 .. 50,000,000",0.0f));
        gameRepository.save(new Game(0L,550,"Left 4 Dead 2","Valve",404531,11920,"20,000,000 .. 50,000,000",1.99f));
        gameRepository.save(new Game(0L,359550,"Tom Clancy's Rainbow Six Siege","Ubisoft Montreal",685701,94419,"20,000,000 .. 50,000,000",7.99f));
        gameRepository.save(new Game(0L,945360,"Among Us","Innersloth",304183,13684,"20,000,000 .. 50,000,000",4.99f));
        gameRepository.save(new Game(0L,271590,"Grand Theft Auto V","Rockstar North",773360,184657,"20,000,000 .. 50,000,000",14.99f));
        gameRepository.save(new Game(0L,4000,"Garry's Mod","Facepunch Studios",596073,22020,"20,000,000 .. 50,000,000",6.69f));
        gameRepository.save(new Game(0L,10,"Counter-Strike","Valve",163210,4268,"10,000,000 .. 20,000,000",9.99f));
        gameRepository.save(new Game(0L,340,"Half-Life 2: Lost Coast","Valve",7293,1141,"10,000,000 .. 20,000,000",0.0f));
        gameRepository.save(new Game(0L,236390,"War Thunder","Gaijin Entertainment",144719,35270,"10,000,000 .. 20,000,000",0.0f));
        gameRepository.save(new Game(0L,444090,"Paladins","Evil Mojo Games",241160,40625,"10,000,000 .. 20,000,000",0.0f));
        gameRepository.save(new Game(0L,272060,"Serena","Senscape",4760,1423,"10,000,000 .. 20,000,000",0.0f));
        gameRepository.save(new Game(0L,218620,"PAYDAY 2","OVERKILL - a Starbreeze Studio.",404133,59047,"10,000,000 .. 20,000,000",4.99f));
        gameRepository.save(new Game(0L,238960,"Path of Exile","Grinding Gear Games",134626,9783,"10,000,000 .. 20,000,000",0.0f));
        gameRepository.save(new Game(0L,105600,"Terraria","Re-Logic",595227,13119,"10,000,000 .. 20,000,000",4.99f));
        gameRepository.save(new Game(0L,49520,"Borderlands 2","Gearbox Software, Aspyr (Mac), Aspyr (Linux)",220171,15618,"10,000,000 .. 20,000,000",19.99f));
        gameRepository.save(new Game(0L,291550,"Brawlhalla","Blue Mammoth Games",153213,27518,"10,000,000 .. 20,000,000",0.0f));
        gameRepository.save(new Game(0L,227940,"Heroes & Generals","RETO MOTO",83911,40784,"10,000,000 .. 20,000,000",0.0f));
        gameRepository.save(new Game(0L,1085660,"Destiny 2","Bungie",251172,37498,"10,000,000 .. 20,000,000",0.0f));
        gameRepository.save(new Game(0L,240,"Counter-Strike: Source","Valve",108003,4471,"10,000,000 .. 20,000,000",9.99f));
        gameRepository.save(new Game(0L,275390,"Guacamelee! Super Turbo Championship Edition","DrinkBox Studios",4774,398,"10,000,000 .. 20,000,000",4.49f));
        gameRepository.save(new Game(0L,291480,"Warface","MY.GAMES",42297,19114,"10,000,000 .. 20,000,000",0.0f));
        gameRepository.save(new Game(0L,252490,"Rust","Facepunch Studios",414030,76369,"10,000,000 .. 20,000,000",26.79f));
        gameRepository.save(new Game(0L,220,"Half-Life 2","Valve",106135,3052,"10,000,000 .. 20,000,000",1.99f));
        gameRepository.save(new Game(0L,252950,"Rocket League","Psyonix LLC",426888,52342,"10,000,000 .. 20,000,000",0.0f));
        gameRepository.save(new Game(0L,620,"Portal 2","Valve",212560,2652,"10,000,000 .. 20,000,000",1.99f));
        gameRepository.save(new Game(0L,550650,"Black Squad","NS STUDIO, VALOFE",55509,16015,"10,000,000 .. 20,000,000",0.0f));
        gameRepository.save(new Game(0L,304050,"Trove","Trion Worlds",61691,15352,"10,000,000 .. 20,000,000",0.0f));
        gameRepository.save(new Game(0L,755790,"Ring of Elysium","Aurora Studio",68951,22414,"10,000,000 .. 20,000,000",0.0f));
        gameRepository.save(new Game(0L,386360,"SMITE","Titan Forge Games",59983,14145,"10,000,000 .. 20,000,000",0.0f));
        gameRepository.save(new Game(0L,433850,"Z1 Battle Royale","Daybreak Game Company",114787,93575,"10,000,000 .. 20,000,000",0.0f));
        gameRepository.save(new Game(0L,431960,"Wallpaper Engine","Wallpaper Engine Team",241510,4388,"10,000,000 .. 20,000,000",3.99f));
        gameRepository.save(new Game(0L,320,"Half-Life 2: Deathmatch","Valve",7885,909,"10,000,000 .. 20,000,000",0.99f));
        gameRepository.save(new Game(0L,44350,"GRID 2","Codemasters Racing",21100,4342,"10,000,000 .. 20,000,000",0.0f));
        gameRepository.save(new Game(0L,219990,"Grim Dawn","Crate Entertainment",52929,4022,"10,000,000 .. 20,000,000",6.24f));
        gameRepository.save(new Game(0L,360,"Half-Life Deathmatch: Source","Valve",1919,619,"10,000,000 .. 20,000,000",1.99f));
        gameRepository.save(new Game(0L,8930,"Sid Meier's Civilization V","Firaxis Games, Aspyr (Mac), Aspyr (Linux)",161387,6492,"5,000,000 .. 10,000,000",29.99f));
        gameRepository.save(new Game(0L,582010,"Monster Hunter: World","CAPCOM Co., Ltd.",229821,45135,"5,000,000 .. 10,000,000",19.79f));
        gameRepository.save(new Game(0L,292030,"The Witcher 3: Wild Hunt","CD PROJEKT RED",418151,8272,"5,000,000 .. 10,000,000",11.99f));
        gameRepository.save(new Game(0L,70,"Half-Life","Valve",50266,1874,"5,000,000 .. 10,000,000",1.99f));
        gameRepository.save(new Game(0L,72850,"The Elder Scrolls V: Skyrim","Bethesda Game Studios",275257,15453,"5,000,000 .. 10,000,000",19.99f));
        gameRepository.save(new Game(0L,477160,"Human: Fall Flat","No Brakes Games",105256,6628,"5,000,000 .. 10,000,000",5.99f));
        gameRepository.save(new Game(0L,227300,"Euro Truck Simulator 2","SCS Software",342086,9070,"5,000,000 .. 10,000,000",4.99f));
        gameRepository.save(new Game(0L,346110,"ARK: Survival Evolved","Studio Wildcard, Instinct Games, Efecto Studios, Virtual Basement LLC",288451,82435,"5,000,000 .. 10,000,000",9.99f));
        gameRepository.save(new Game(0L,400,"Portal","Valve",75941,1345,"5,000,000 .. 10,000,000",1.99f));
        gameRepository.save(new Game(0L,224260,"No More Room in Hell","No More Room in Hell Team",52876,6164,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,50,"Half-Life: Opposing Force","Gearbox Software",9386,492,"5,000,000 .. 10,000,000",4.99f));
        gameRepository.save(new Game(0L,218230,"PlanetSide 2","Rogue Planet Games",47581,9899,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,333930,"Dirty Bomb","Splash Damage",46863,11050,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,381210,"Dead by Daylight","Behaviour Interactive Inc.",311855,69477,"5,000,000 .. 10,000,000",7.99f));
        gameRepository.save(new Game(0L,130,"Half-Life: Blue Shift","Gearbox Software",6738,697,"5,000,000 .. 10,000,000",0.99f));
        gameRepository.save(new Game(0L,739630,"Phasmophobia","Kinetic Games",72450,2363,"5,000,000 .. 10,000,000",12.59f));
        gameRepository.save(new Game(0L,203160,"Tomb Raider","Crystal Dynamics, Eidos-Montréal, Feral Interactive (Mac), Feral Interactive (Linux)",165973,6437,"5,000,000 .. 10,000,000",2.99f));
        gameRepository.save(new Game(0L,322330,"Don't Starve Together","Klei Entertainment",206376,7934,"5,000,000 .. 10,000,000",5.09f));
        gameRepository.save(new Game(0L,1046930,"Dota Underlords","Valve",71083,13861,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,582660,"Black Desert Online","Pearl Abyss",25564,8757,"5,000,000 .. 10,000,000",4.99f));
        gameRepository.save(new Game(0L,278360,"A Story About My Uncle","Gone North Games",23889,2088,"5,000,000 .. 10,000,000",4.49f));
        gameRepository.save(new Game(0L,60,"Ricochet","Valve",3310,774,"5,000,000 .. 10,000,000",4.99f));
        gameRepository.save(new Game(0L,444200,"World of Tanks Blitz","Wargaming Group Limited",44650,12169,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,273110,"Counter-Strike Nexon: Studio","Valve Corporation, Nexon Korea Corporation",24648,12928,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,261550,"Mount & Blade II: Bannerlord","TaleWorlds Entertainment",117436,17753,"5,000,000 .. 10,000,000",44.99f));
        gameRepository.save(new Game(0L,255710,"Cities: Skylines","Colossal Order Ltd.",125961,10034,"5,000,000 .. 10,000,000",29.99f));
        gameRepository.save(new Game(0L,413150,"Stardew Valley","ConcernedApe",269633,6437,"5,000,000 .. 10,000,000",11.99f));
        gameRepository.save(new Game(0L,1089350,"NBA 2K20","Visual Concepts",25539,26364,"5,000,000 .. 10,000,000",59.99f));
        gameRepository.save(new Game(0L,417910,"Street Warriors Online","Crazy Rocks Studios",977,722,"5,000,000 .. 10,000,000",1.99f));
        gameRepository.save(new Game(0L,588430,"Fallout Shelter","Bethesda Game Studios",33281,4679,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,221380,"Age of Empires II (2013)","Skybox Labs, Hidden Path Entertainment, Ensemble Studios, Forgotten Empires",80281,3836,"5,000,000 .. 10,000,000",19.99f));
        gameRepository.save(new Game(0L,500,"Left 4 Dead","Valve",27732,1242,"5,000,000 .. 10,000,000",1.99f));
        gameRepository.save(new Game(0L,10180,"Call of Duty: Modern Warfare 2","Infinity Ward",37028,3089,"5,000,000 .. 10,000,000",19.99f));
        gameRepository.save(new Game(0L,439700,"Z1 Battle Royale: Test Server","Daybreak Game Company",1282,1131,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,700330,"SCP: Secret Laboratory","Northwood Studios",71171,7316,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,601150,"Devil May Cry 5","CAPCOM Co., Ltd.",46853,3584,"5,000,000 .. 10,000,000",19.99f));
        gameRepository.save(new Game(0L,30,"Day of Defeat","Valve",4402,486,"5,000,000 .. 10,000,000",4.99f));
        gameRepository.save(new Game(0L,300,"Day of Defeat: Source","Valve",13498,1419,"5,000,000 .. 10,000,000",9.99f));
        gameRepository.save(new Game(0L,377160,"Fallout 4","Bethesda Game Studios",168692,49256,"5,000,000 .. 10,000,000",29.99f));
        gameRepository.save(new Game(0L,863550,"HITMAN 2","IO Interactive A/S",38733,4280,"5,000,000 .. 10,000,000",29.99f));
        gameRepository.save(new Game(0L,40,"Deathmatch Classic","Valve",1618,350,"5,000,000 .. 10,000,000",4.99f));
        gameRepository.save(new Game(0L,420,"Half-Life 2: Episode Two","Valve",21088,789,"5,000,000 .. 10,000,000",1.59f));
        gameRepository.save(new Game(0L,813820,"Realm Royale","Heroic Leap Games",31909,11760,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,648800,"Raft","Redbeet Interactive",67111,7048,"5,000,000 .. 10,000,000",19.99f));
        gameRepository.save(new Game(0L,109600,"Neverwinter","Cryptic Studios",23013,6490,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,219740,"Don't Starve","Klei Entertainment",79327,2607,"5,000,000 .. 10,000,000",2.49f));
        gameRepository.save(new Game(0L,204360,"Castle Crashers","The Behemoth",66821,2780,"5,000,000 .. 10,000,000",2.99f));
        gameRepository.save(new Game(0L,380,"Half-Life 2: Episode One","Valve",13633,727,"5,000,000 .. 10,000,000",1.59f));
        gameRepository.save(new Game(0L,239140,"Dying Light","Techland",184739,10276,"5,000,000 .. 10,000,000",13.59f));
        gameRepository.save(new Game(0L,253710,"theHunter Classic","Expansive Worlds, Avalanche Studios",15811,16040,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,532210,"Life is Strange 2","DONTNOD Entertainment, Feral Interactive (Mac), Feral Interactive (Linux)",15112,2981,"5,000,000 .. 10,000,000",14.4f));
        gameRepository.save(new Game(0L,555570,"Infestation: The New Z","Fredaikis AB",16299,15175,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,273350,"Evolve Stage 2","Turtle Rock Studios",30953,14897,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,208090,"Loadout","Edge of Reality",35148,5431,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,1097150,"Fall Guys: Ultimate Knockout","Mediatonic",206684,51183,"5,000,000 .. 10,000,000",19.99f));
        gameRepository.save(new Game(0L,15700,"Oddworld: Abe's Oddysee","Oddworld Inhabitants",3105,504,"5,000,000 .. 10,000,000",2.99f));
        gameRepository.save(new Game(0L,407530,"ARK: Survival Of The Fittest","Studio Wildcard, Instinct Games, Efecto Studios, Virtual Basement LLC",5501,3449,"5,000,000 .. 10,000,000",9.99f));
        gameRepository.save(new Game(0L,346900,"AdVenture Capitalist","Hyper Hippo Games",39275,5078,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,113400,"APB Reloaded","Little Orbit",22014,12601,"5,000,000 .. 10,000,000",0.0f));
        gameRepository.save(new Game(0L,387990,"Scrap Mechanic","Axolot Games",52973,5050,"5,000,000 .. 10,000,000",13.39f));
    }

    @Override
    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game getGameById(Long id) {
        return gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException("The game with the given ID was not found!"));
    }

    @Override
    public Game addGame(Game game) {
        game.setId(0);
        return gameRepository.save(game);
    }

    @Override
    public Game updateGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
