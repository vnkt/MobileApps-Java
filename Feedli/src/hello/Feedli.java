/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hello;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import org.netbeans.microedition.lcdui.SplashScreen;
import hello.parser.KXmlRssParser;
import hello.parser.RssItem;
import java.util.Vector;
import org.netbeans.microedition.util.SimpleCancellableTask;
import javax.wireless.messaging.*;
import javax.microedition.io.Connector;


/**
 * @author vnKt
 */
public class Feedli extends MIDlet implements CommandListener, MessageListener {

    private boolean midletPaused = false;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Command exitCommand;
    private Command Okay;
    private Command okCommand;
    private Command backCommand1;
    private Command backCommand;
    private Command okCommand1;
    private Command exitCommand1;
    private Command backCommand3;
    private Command backCommand2;
    private Command backCommand5;
    private Command backCommand4;
    private Command SMStofriend1;
    private Command SMStofriend;
    private Command backCommand6;
    private SplashScreen WelcomeScreen;
    private Form Credits;
    private StringItem stringItem;
    private Form Help;
    private StringItem stringItem1;
    private Form Configure;
    private TextField textField2;
    private ChoiceGroup choiceGroup;
    private TextField textField;
    private TextField textField1;
    private Spacer spacer;
    private List EntryOptions1;
    private List FeedList;
    private List InternationalNews;
    private List Cinema;
    private List Technology;
    private List Gadgets;
    private List BusinessStats;
    private List Sports;
    private List Stocks;
    private List NationalNews;
    private List Cricket;
    private List Football;
    private List Tennis;
    private List Hollywood;
    private List Bollywood;
    private List Basketball;
    private List Rugby;
    private List Golf;
    private List Baseball;
    private List F1;
    private List Hockey;
    private List ArtsBooks;
    private List User1;
    private List User2;
    private List MotoGP;
    private Form About;
    private TextField textField3;
    private Image welcome;
    private Image creditpic;
    private Image helppic;
    private Image configpic;
    private Image feedspic;
    private SimpleCancellableTask task;
    private Image art;
    private Image sports2;
    private Image stocks1;
    private Image business;
    private Image holly;
    private Image tennis1;
    private Image base;
    private Image cric;
    private Image foot;
    private Image hockey1;
    private Image rugby1;
    private Image f2;
    private Image national;
    private Image cinema2;
    private Image basket;
    private Image inter;
    private Image user;
    private Image moto;
    private Image golfpic;
    private Image gadgets1;
    private Image rss;
    private Image feedspic1;
    private Image tech;
    //</editor-fold>//GEN-END:|fields|0|
    private String[] nationva = {"africa", "asia_pacific", "europe", "latin_america", "middle_east", "south_asia", "us_and_canda", "england"};
    private int nation;
    private String user1, user2, id;
    private MessageConnection conn2 = null;
    /**
     * The Feedli constructor.
     */
    public Feedli() {
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize

    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getWelcomeScreen());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == ArtsBooks) {//GEN-BEGIN:|7-commandAction|1|282-preAction
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|1|282-preAction
                // write pre-action user code here
                ArtsBooksAction();//GEN-LINE:|7-commandAction|2|282-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|3|348-preAction
                sendMsg(id,"0",ArtsBooks.getString(ArtsBooks.getSelectedIndex()));
//GEN-LINE:|7-commandAction|4|348-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|5|285-preAction
                // write pre-action user code here
                switchDisplayable(null, getFeedList());//GEN-LINE:|7-commandAction|6|285-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|7|211-preAction
        } else if (displayable == Baseball) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|7|211-preAction
                // write pre-action user code here
                BaseballAction();//GEN-LINE:|7-commandAction|8|211-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|9|356-preAction
                sendMsg(id,"0",Baseball.getString(Baseball.getSelectedIndex()));
//GEN-LINE:|7-commandAction|10|356-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|11|250-preAction
                // write pre-action user code here
                switchDisplayable(null, getSports());//GEN-LINE:|7-commandAction|12|250-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|13|194-preAction
        } else if (displayable == Basketball) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|13|194-preAction
                // write pre-action user code here
                BasketballAction();//GEN-LINE:|7-commandAction|14|194-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|15|354-preAction
                sendMsg(id,"0",Basketball.getString(Basketball.getSelectedIndex()));
//GEN-LINE:|7-commandAction|16|354-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|17|246-preAction
                // write pre-action user code here
                switchDisplayable(null, getSports());//GEN-LINE:|7-commandAction|18|246-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|19|200-preAction
        } else if (displayable == Bollywood) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|19|200-preAction
                // write pre-action user code here
                BollywoodAction();//GEN-LINE:|7-commandAction|20|200-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|21|349-preAction
               sendMsg(id,"0",Bollywood.getString(Bollywood.getSelectedIndex()));
//GEN-LINE:|7-commandAction|22|349-postAction
                // write post-action user code here
            } else if (command == backCommand2) {//GEN-LINE:|7-commandAction|23|235-preAction
                // write pre-action user code here
                switchDisplayable(null, getCinema());//GEN-LINE:|7-commandAction|24|235-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|25|126-preAction
        } else if (displayable == BusinessStats) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|25|126-preAction
                // write pre-action user code here
                BusinessStatsAction();//GEN-LINE:|7-commandAction|26|126-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|27|347-preAction
               sendMsg(id,"0",BusinessStats.getString(BusinessStats.getSelectedIndex()));
//GEN-LINE:|7-commandAction|28|347-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|29|153-preAction
                // write pre-action user code here
                switchDisplayable(null, getFeedList());//GEN-LINE:|7-commandAction|30|153-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|31|108-preAction
        } else if (displayable == Cinema) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|31|108-preAction
                // write pre-action user code here
                CinemaAction();//GEN-LINE:|7-commandAction|32|108-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|33|148-preAction
                // write pre-action user code here
                switchDisplayable(null, getFeedList());//GEN-LINE:|7-commandAction|34|148-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|35|50-preAction
        } else if (displayable == Configure) {
            if (command == backCommand) {//GEN-END:|7-commandAction|35|50-preAction
                // write pre-action user code here
                switchDisplayable(null, getEntryOptions1());//GEN-LINE:|7-commandAction|36|50-postAction
                // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|37|51-preAction
                nation = choiceGroup.getSelectedIndex();
                user1 = textField.getString();
                user2 = textField1.getString();
                id = textField2.getString();
                switchDisplayable(null, getEntryOptions1());//GEN-LINE:|7-commandAction|38|51-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|39|47-preAction
        } else if (displayable == Credits) {
            if (command == backCommand1) {//GEN-END:|7-commandAction|39|47-preAction

                switchDisplayable(null, getEntryOptions1());//GEN-LINE:|7-commandAction|40|47-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|41|186-preAction
        } else if (displayable == Cricket) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|41|186-preAction
                // write pre-action user code here
                CricketAction();//GEN-LINE:|7-commandAction|42|186-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|43|352-preAction
                sendMsg(id,"0",Cricket.getString(Cricket.getSelectedIndex()));
//GEN-LINE:|7-commandAction|44|352-postAction
                // write post-action user code here
            } else if (command == backCommand4) {//GEN-LINE:|7-commandAction|45|241-preAction
                // write pre-action user code here
                switchDisplayable(null, getSports());//GEN-LINE:|7-commandAction|46|241-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|47|60-preAction
        } else if (displayable == EntryOptions1) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|47|60-preAction
                // write pre-action user code here
                EntryOptions1Action();//GEN-LINE:|7-commandAction|48|60-postAction
                // write post-action user code here
            } else if (command == exitCommand1) {//GEN-LINE:|7-commandAction|49|65-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|50|65-postAction
                // write post-action user code here
            } else if (command == okCommand1) {//GEN-LINE:|7-commandAction|51|63-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|52|63-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|53|229-preAction
        } else if (displayable == F1) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|53|229-preAction
                // write pre-action user code here
                F1Action();//GEN-LINE:|7-commandAction|54|229-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|55|360-preAction
                sendMsg(id,"0",F1.getString(F1.getSelectedIndex()));
//GEN-LINE:|7-commandAction|56|360-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|57|254-preAction
                // write pre-action user code here
                switchDisplayable(null, getSports());//GEN-LINE:|7-commandAction|58|254-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|59|71-preAction
        } else if (displayable == FeedList) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|59|71-preAction
                // write pre-action user code here
                FeedListAction();//GEN-LINE:|7-commandAction|60|71-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|61|75-preAction
                // write pre-action user code here
                switchDisplayable(null, getEntryOptions1());//GEN-LINE:|7-commandAction|62|75-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|63|189-preAction
        } else if (displayable == Football) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|63|189-preAction
                // write pre-action user code here
                FootballAction();//GEN-LINE:|7-commandAction|64|189-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|65|353-preAction
               sendMsg(id,"0",Football.getString(Football.getSelectedIndex()));
//GEN-LINE:|7-commandAction|66|353-postAction
                // write post-action user code here
            } else if (command == backCommand5) {//GEN-LINE:|7-commandAction|67|244-preAction
                // write pre-action user code here
                switchDisplayable(null, getSports());//GEN-LINE:|7-commandAction|68|244-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|69|114-preAction
        } else if (displayable == Gadgets) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|69|114-preAction
                // write pre-action user code here
                GadgetsAction();//GEN-LINE:|7-commandAction|70|114-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|71|344-preAction
               sendMsg(id,"0",User1.getString(Gadgets.getSelectedIndex()));
//GEN-LINE:|7-commandAction|72|344-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|73|156-preAction
                // write pre-action user code here
                switchDisplayable(null, getFeedList());//GEN-LINE:|7-commandAction|74|156-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|75|216-preAction
        } else if (displayable == Golf) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|75|216-preAction
                // write pre-action user code here
                GolfAction();//GEN-LINE:|7-commandAction|76|216-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|77|357-preAction
                sendMsg(id,"0",Golf.getString(Golf.getSelectedIndex()));
//GEN-LINE:|7-commandAction|78|357-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|79|251-preAction
                // write pre-action user code here
                switchDisplayable(null, getSports());//GEN-LINE:|7-commandAction|80|251-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|81|45-preAction
        } else if (displayable == Help) {
            if (command == backCommand) {//GEN-END:|7-commandAction|81|45-preAction
                // write pre-action user code here
                switchDisplayable(null, getEntryOptions1());//GEN-LINE:|7-commandAction|82|45-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|83|226-preAction
        } else if (displayable == Hockey) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|83|226-preAction
                // write pre-action user code here
                HockeyAction();//GEN-LINE:|7-commandAction|84|226-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|85|359-preAction
                sendMsg(id,"0",Hockey.getString(Hockey.getSelectedIndex()));
//GEN-LINE:|7-commandAction|86|359-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|87|253-preAction
                // write pre-action user code here
                switchDisplayable(null, getSports());//GEN-LINE:|7-commandAction|88|253-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|89|203-preAction
        } else if (displayable == Hollywood) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|89|203-preAction
                // write pre-action user code here
                HollywoodAction();//GEN-LINE:|7-commandAction|90|203-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|91|350-preAction
                sendMsg(id,"0",Hollywood.getString(Hollywood.getSelectedIndex()));
//GEN-LINE:|7-commandAction|92|350-postAction
                // write post-action user code here
            } else if (command == backCommand3) {//GEN-LINE:|7-commandAction|93|237-preAction
                // write pre-action user code here
                switchDisplayable(null, getCinema());//GEN-LINE:|7-commandAction|94|237-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|95|104-preAction
        } else if (displayable == InternationalNews) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|95|104-preAction
                // write pre-action user code here
                InternationalNewsAction();//GEN-LINE:|7-commandAction|96|104-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|97|345-preAction
                sendMsg(id,"0",InternationalNews.getString(InternationalNews.getSelectedIndex()));
//GEN-LINE:|7-commandAction|98|345-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|99|146-preAction
                // write pre-action user code here
                switchDisplayable(null, getFeedList());//GEN-LINE:|7-commandAction|100|146-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|101|320-preAction
        } else if (displayable == MotoGP) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|101|320-preAction
                // write pre-action user code here
                MotoGPAction();//GEN-LINE:|7-commandAction|102|320-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|103|361-preAction
                sendMsg(id,"0",MotoGP.getString(MotoGP.getSelectedIndex()));
//GEN-LINE:|7-commandAction|104|361-postAction
                // write post-action user code here
            } else if (command == backCommand6) {//GEN-LINE:|7-commandAction|105|329-preAction
                // write pre-action user code here
                switchDisplayable(null, getSports());//GEN-LINE:|7-commandAction|106|329-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|107|134-preAction
        } else if (displayable == NationalNews) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|107|134-preAction
                // write pre-action user code here
                NationalNewsAction();//GEN-LINE:|7-commandAction|108|134-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|109|346-preAction
                sendMsg(id,"0",NationalNews.getString(NationalNews.getSelectedIndex()));
//GEN-LINE:|7-commandAction|110|346-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|111|147-preAction
                // write pre-action user code here
                switchDisplayable(null, getFeedList());//GEN-LINE:|7-commandAction|112|147-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|113|223-preAction
        } else if (displayable == Rugby) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|113|223-preAction
                // write pre-action user code here
                RugbyAction();//GEN-LINE:|7-commandAction|114|223-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|115|358-preAction
                sendMsg(id,"0",Rugby.getString(Rugby.getSelectedIndex()));
//GEN-LINE:|7-commandAction|116|358-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|117|252-preAction
                // write pre-action user code here
                switchDisplayable(null, getSports());//GEN-LINE:|7-commandAction|118|252-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|119|123-preAction
        } else if (displayable == Sports) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|119|123-preAction
                // write pre-action user code here
                SportsAction();//GEN-LINE:|7-commandAction|120|123-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|121|154-preAction
                // write pre-action user code here
                switchDisplayable(null, getFeedList());//GEN-LINE:|7-commandAction|122|154-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|123|129-preAction
        } else if (displayable == Stocks) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|123|129-preAction
                // write pre-action user code here
                StocksAction();//GEN-LINE:|7-commandAction|124|129-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|125|351-preAction
               sendMsg(id,"0",Stocks.getString(Stocks.getSelectedIndex()));
//GEN-LINE:|7-commandAction|126|351-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|127|152-preAction
                // write pre-action user code here
                switchDisplayable(null, getFeedList());//GEN-LINE:|7-commandAction|128|152-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|129|117-preAction
        } else if (displayable == Technology) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|129|117-preAction
                // write pre-action user code here
                TechnologyAction();//GEN-LINE:|7-commandAction|130|117-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|131|362-preAction
                sendMsg(id,"0",Technology.getString(Technology.getSelectedIndex()));
//GEN-LINE:|7-commandAction|132|362-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|133|150-preAction
                // write pre-action user code here
                switchDisplayable(null, getFeedList());//GEN-LINE:|7-commandAction|134|150-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|135|208-preAction
        } else if (displayable == Tennis) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|135|208-preAction
                // write pre-action user code here
                TennisAction();//GEN-LINE:|7-commandAction|136|208-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|137|355-preAction
                sendMsg(id,"0",Tennis.getString(Tennis.getSelectedIndex()));
//GEN-LINE:|7-commandAction|138|355-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|139|247-preAction
                // write pre-action user code here
                switchDisplayable(null, getSports());//GEN-LINE:|7-commandAction|140|247-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|141|308-preAction
        } else if (displayable == User1) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|141|308-preAction
                // write pre-action user code here
                User1Action();//GEN-LINE:|7-commandAction|142|308-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|143|342-preAction
                sendMsg(id,"0",User1.getString(User1.getSelectedIndex()));
//GEN-LINE:|7-commandAction|144|342-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|145|313-preAction
                // write pre-action user code here
                switchDisplayable(null, getFeedList());//GEN-LINE:|7-commandAction|146|313-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|147|311-preAction
        } else if (displayable == User2) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|147|311-preAction
                // write pre-action user code here
                User2Action();//GEN-LINE:|7-commandAction|148|311-postAction
                // write post-action user code here
            } else if (command == SMStofriend1) {//GEN-LINE:|7-commandAction|149|343-preAction
               sendMsg(id,"0",User2.getString(User2.getSelectedIndex()));
//GEN-LINE:|7-commandAction|150|343-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|151|314-preAction
                // write pre-action user code here
                switchDisplayable(null, getFeedList());//GEN-LINE:|7-commandAction|152|314-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|153|24-preAction
        } else if (displayable == WelcomeScreen) {
            if (command == SplashScreen.DISMISS_COMMAND) {//GEN-END:|7-commandAction|153|24-preAction
                // write pre-action user code here
                switchDisplayable(null, getEntryOptions1());//GEN-LINE:|7-commandAction|154|24-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|155|7-postCommandAction
        }//GEN-END:|7-commandAction|155|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|156|
    //</editor-fold>//GEN-END:|7-commandAction|156|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: WelcomeScreen ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of WelcomeScreen component.
     * @return the initialized component instance
     */
    public SplashScreen getWelcomeScreen() {
        if (WelcomeScreen == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            WelcomeScreen = new SplashScreen(getDisplay());//GEN-BEGIN:|22-getter|1|22-postInit
            WelcomeScreen.setTitle("Welcome to Feedli ");
            WelcomeScreen.setCommandListener(this);
            WelcomeScreen.setImage(getWelcome());
            WelcomeScreen.setText("");//GEN-END:|22-getter|1|22-postInit
            // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return WelcomeScreen;
    }
    //</editor-fold>//GEN-END:|22-getter|2|
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: welcome ">//GEN-BEGIN:|25-getter|0|25-preInit
    /**
     * Returns an initiliazed instance of welcome component.
     * @return the initialized component instance
     */
    public Image getWelcome() {
        if (welcome == null) {//GEN-END:|25-getter|0|25-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|25-getter|1|25-@java.io.IOException
                welcome = Image.createImage("/feedli ne.png");
            } catch (java.io.IOException e) {//GEN-END:|25-getter|1|25-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|25-getter|2|25-postInit
            // write post-init user code here
        }//GEN-BEGIN:|25-getter|3|
        return welcome;
    }
    //</editor-fold>//GEN-END:|25-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Okay ">//GEN-BEGIN:|26-getter|0|26-preInit
    /**
     * Returns an initiliazed instance of Okay component.
     * @return the initialized component instance
     */
    public Command getOkay() {
        if (Okay == null) {//GEN-END:|26-getter|0|26-preInit
            // write pre-init user code here
            Okay = new Command("Screen", Command.SCREEN, 0);//GEN-LINE:|26-getter|1|26-postInit
            // write post-init user code here
        }//GEN-BEGIN:|26-getter|2|
        return Okay;
    }
    //</editor-fold>//GEN-END:|26-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|38-getter|0|38-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|38-getter|0|38-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|38-getter|1|38-postInit
            // write post-init user code here
        }//GEN-BEGIN:|38-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|38-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Help ">//GEN-BEGIN:|40-getter|0|40-preInit
    /**
     * Returns an initiliazed instance of Help component.
     * @return the initialized component instance
     */
    public Form getHelp() {
        if (Help == null) {//GEN-END:|40-getter|0|40-preInit
            // write pre-init user code here
            Help = new Form("Help", new Item[] { getStringItem1() });//GEN-BEGIN:|40-getter|1|40-postInit
            Help.addCommand(getBackCommand());
            Help.setCommandListener(this);//GEN-END:|40-getter|1|40-postInit
            // write post-init user code here
        }//GEN-BEGIN:|40-getter|2|
        return Help;
    }
    //</editor-fold>//GEN-END:|40-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Configure ">//GEN-BEGIN:|41-getter|0|41-preInit
    /**
     * Returns an initiliazed instance of Configure component.
     * @return the initialized component instance
     */
    public Form getConfigure() {
        if (Configure == null) {//GEN-END:|41-getter|0|41-preInit
            // write pre-init user code here
            Configure = new Form("Settings ", new Item[] { getChoiceGroup(), getTextField(), getTextField1(), getSpacer(), getTextField2() });//GEN-BEGIN:|41-getter|1|41-postInit
            Configure.addCommand(getOkCommand());
            Configure.addCommand(getBackCommand());
            Configure.setCommandListener(this);//GEN-END:|41-getter|1|41-postInit
            // write post-init user code here
        }//GEN-BEGIN:|41-getter|2|
        return Configure;
    }
    //</editor-fold>//GEN-END:|41-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Credits ">//GEN-BEGIN:|42-getter|0|42-preInit
    /**
     * Returns an initiliazed instance of Credits component.
     * @return the initialized component instance
     */
    public Form getCredits() {
        if (Credits == null) {//GEN-END:|42-getter|0|42-preInit
            // write pre-init user code here
            Credits = new Form("Credits", new Item[] { getStringItem() });//GEN-BEGIN:|42-getter|1|42-postInit
            Credits.addCommand(getBackCommand1());
            Credits.setCommandListener(this);//GEN-END:|42-getter|1|42-postInit
            // write post-init user code here
        }//GEN-BEGIN:|42-getter|2|
        return Credits;
    }
    //</editor-fold>//GEN-END:|42-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|44-getter|0|44-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|44-getter|0|44-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|44-getter|1|44-postInit
            // write post-init user code here
        }//GEN-BEGIN:|44-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|44-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|46-getter|0|46-preInit
    /**
     * Returns an initiliazed instance of backCommand1 component.
     * @return the initialized component instance
     */
    public Command getBackCommand1() {
        if (backCommand1 == null) {//GEN-END:|46-getter|0|46-preInit
            // write pre-init user code here
            backCommand1 = new Command("Back", Command.BACK, 0);//GEN-LINE:|46-getter|1|46-postInit
            // write post-init user code here
        }//GEN-BEGIN:|46-getter|2|
        return backCommand1;
    }
    //</editor-fold>//GEN-END:|46-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand1 ">//GEN-BEGIN:|62-getter|0|62-preInit
    /**
     * Returns an initiliazed instance of okCommand1 component.
     * @return the initialized component instance
     */
    public Command getOkCommand1() {
        if (okCommand1 == null) {//GEN-END:|62-getter|0|62-preInit
            // write pre-init user code here
            okCommand1 = new Command("Ok", Command.OK, 0);//GEN-LINE:|62-getter|1|62-postInit
            // write post-init user code here
        }//GEN-BEGIN:|62-getter|2|
        return okCommand1;
    }
    //</editor-fold>//GEN-END:|62-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|64-getter|0|64-preInit
    /**
     * Returns an initiliazed instance of exitCommand1 component.
     * @return the initialized component instance
     */
    public Command getExitCommand1() {
        if (exitCommand1 == null) {//GEN-END:|64-getter|0|64-preInit
            // write pre-init user code here
            exitCommand1 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|64-getter|1|64-postInit
            // write post-init user code here
        }//GEN-BEGIN:|64-getter|2|
        return exitCommand1;
    }
    //</editor-fold>//GEN-END:|64-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: EntryOptions1 ">//GEN-BEGIN:|59-getter|0|59-preInit
    /**
     * Returns an initiliazed instance of EntryOptions1 component.
     * @return the initialized component instance
     */
    public List getEntryOptions1() {
        if (EntryOptions1 == null) {//GEN-END:|59-getter|0|59-preInit
            // write pre-init user code here
            EntryOptions1 = new List("Welcome user .. Howdy ?", Choice.IMPLICIT);//GEN-BEGIN:|59-getter|1|59-postInit
            EntryOptions1.append("  Go to Feeds", getFeedspic1());
            EntryOptions1.append("  Configure", getConfigpic());
            EntryOptions1.append("  Help", getHelppic());
            EntryOptions1.append(" Credits", getCreditpic());
            EntryOptions1.append("About", null);
            EntryOptions1.append("Exit", null);
            EntryOptions1.addCommand(getOkCommand1());
            EntryOptions1.addCommand(getExitCommand1());
            EntryOptions1.setCommandListener(this);
            EntryOptions1.setSelectedFlags(new boolean[] { false, false, false, false, false, false });//GEN-END:|59-getter|1|59-postInit
            // write post-init user code here
        }//GEN-BEGIN:|59-getter|2|
        return EntryOptions1;
    }
    //</editor-fold>//GEN-END:|59-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: EntryOptions1Action ">//GEN-BEGIN:|59-action|0|59-preAction
    /**
     * Performs an action assigned to the selected list element in the EntryOptions1 component.
     */
    public void EntryOptions1Action() {//GEN-END:|59-action|0|59-preAction
        // enter pre-action user code here
        String __selectedString = getEntryOptions1().getString(getEntryOptions1().getSelectedIndex());//GEN-BEGIN:|59-action|1|85-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("  Go to Feeds")) {//GEN-END:|59-action|1|85-preAction
                // write pre-action user code here
                switchDisplayable(null, getFeedList());//GEN-LINE:|59-action|2|85-postAction
                // write post-action user code here
            } else if (__selectedString.equals("  Configure")) {//GEN-LINE:|59-action|3|86-preAction
                // write pre-action user code here
                switchDisplayable(null, getConfigure());//GEN-LINE:|59-action|4|86-postAction
                // write post-action user code here
            } else if (__selectedString.equals("  Help")) {//GEN-LINE:|59-action|5|81-preAction
                // write pre-action user code here
                switchDisplayable(null, getHelp());//GEN-LINE:|59-action|6|81-postAction
                // write post-action user code here
            } else if (__selectedString.equals(" Credits")) {//GEN-LINE:|59-action|7|82-preAction
                // write pre-action user code here
                switchDisplayable(null, getCredits());//GEN-LINE:|59-action|8|82-postAction
                // write post-action user code here
            } else if (__selectedString.equals("About")) {//GEN-LINE:|59-action|9|368-preAction
                // write pre-action user code here
                switchDisplayable(null, getAbout());//GEN-LINE:|59-action|10|368-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Exit")) {//GEN-LINE:|59-action|11|369-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|59-action|12|369-postAction
                // write post-action user code here
            }//GEN-BEGIN:|59-action|13|59-postAction
        }//GEN-END:|59-action|13|59-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|59-action|14|
    //</editor-fold>//GEN-END:|59-action|14|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: FeedList ">//GEN-BEGIN:|70-getter|0|70-preInit
    /**
     * Returns an initiliazed instance of FeedList component.
     * @return the initialized component instance
     */
    public List getFeedList() {
        if (FeedList == null) {//GEN-END:|70-getter|0|70-preInit
            // write pre-init user code here
            FeedList = new List("Feeds available", Choice.IMPLICIT);//GEN-BEGIN:|70-getter|1|70-postInit
            FeedList.append("International News", getInter());
            FeedList.append("National News", getNational());
            FeedList.append("Cinema", getCinema2());
            FeedList.append("Sports", getSports2());
            FeedList.append("Arts and Books", getArt());
            FeedList.append("Technology ", getTech());
            FeedList.append("Gadgets", getGadgets1());
            FeedList.append("Business stats", getBusiness());
            FeedList.append("Stocks", getStocks1());
            FeedList.append("User Feed 1", getUser());
            FeedList.append("User Feed 2", getUser());
            FeedList.addCommand(getBackCommand());
            FeedList.setCommandListener(this);
            FeedList.setSelectedFlags(new boolean[] { false, false, false, false, false, false, false, false, false, false, false });//GEN-END:|70-getter|1|70-postInit
            // write post-init user code here
        }//GEN-BEGIN:|70-getter|2|
        return FeedList;
    }
    //</editor-fold>//GEN-END:|70-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: FeedListAction ">//GEN-BEGIN:|70-action|0|70-preAction
    /**
     * Performs an action assigned to the selected list element in the FeedList component.
     */
    public void FeedListAction() {//GEN-END:|70-action|0|70-preAction
        // enter pre-action user code here
        String __selectedString = getFeedList().getString(getFeedList().getSelectedIndex());//GEN-BEGIN:|70-action|1|93-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("International News")) {//GEN-END:|70-action|1|93-preAction
                // write pre-action user code here
                switchDisplayable(null, getInternationalNews());//GEN-LINE:|70-action|2|93-postAction
                // write post-action user code here
            } else if (__selectedString.equals("National News")) {//GEN-LINE:|70-action|3|94-preAction
                // write pre-action user code here
                switchDisplayable(null, getNationalNews());//GEN-LINE:|70-action|4|94-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Cinema")) {//GEN-LINE:|70-action|5|95-preAction
                // write pre-action user code here
                switchDisplayable(null, getCinema());//GEN-LINE:|70-action|6|95-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Sports")) {//GEN-LINE:|70-action|7|100-preAction
                // write pre-action user code here
                switchDisplayable(null, getSports());//GEN-LINE:|70-action|8|100-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Arts and Books")) {//GEN-LINE:|70-action|9|96-preAction
                // write pre-action user code here
                switchDisplayable(null, getArtsBooks());//GEN-LINE:|70-action|10|96-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Technology ")) {//GEN-LINE:|70-action|11|97-preAction
                // write pre-action user code here
                switchDisplayable(null, getTechnology());//GEN-LINE:|70-action|12|97-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Gadgets")) {//GEN-LINE:|70-action|13|98-preAction
                // write pre-action user code here
                switchDisplayable(null, getGadgets());//GEN-LINE:|70-action|14|98-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Business stats")) {//GEN-LINE:|70-action|15|101-preAction
                // write pre-action user code here
                switchDisplayable(null, getBusinessStats());//GEN-LINE:|70-action|16|101-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Stocks")) {//GEN-LINE:|70-action|17|102-preAction
                // write pre-action user code here
                switchDisplayable(null, getStocks());//GEN-LINE:|70-action|18|102-postAction
                // write post-action user code here
            } else if (__selectedString.equals("User Feed 1")) {//GEN-LINE:|70-action|19|305-preAction
                // write pre-action user code here
                switchDisplayable(null, getUser1());//GEN-LINE:|70-action|20|305-postAction
                // write post-action user code here
            } else if (__selectedString.equals("User Feed 2")) {//GEN-LINE:|70-action|21|306-preAction
                // write pre-action user code here
                switchDisplayable(null, getUser2());//GEN-LINE:|70-action|22|306-postAction
                // write post-action user code here
            }//GEN-BEGIN:|70-action|23|70-postAction
        }//GEN-END:|70-action|23|70-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|70-action|24|
    //</editor-fold>//GEN-END:|70-action|24|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: InternationalNews ">//GEN-BEGIN:|103-getter|0|103-preInit
    /**
     * Returns an initiliazed instance of InternationalNews component.
     * @return the initialized component instance
     */
    public List getInternationalNews() {
        if (InternationalNews == null) {//GEN-END:|103-getter|0|103-preInit
            // write pre-init user code here
            InternationalNews = new List("International News", Choice.IMPLICIT);//GEN-BEGIN:|103-getter|1|103-postInit
            InternationalNews.addCommand(getBackCommand());
            InternationalNews.addCommand(getSMStofriend1());
            InternationalNews.setCommandListener(this);
            InternationalNews.setFitPolicy(Choice.TEXT_WRAP_ON);//GEN-END:|103-getter|1|103-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
            Vector rssItems = parser.parse("http://feeds.bbci.co.uk/news/rss.xml?edition=int");
            int value = 0;

			for(int i = 0; i < rssItems.size() && value < 10; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                if(output.substring(0,5).equals("VIDEO"))
                                {
                                }
                                else
                                {
                                    count = output.length();
                                    int z = 0 ;
                                    while(z < s.length())
                                    {
                                        if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                        {
                                            count++;
                                            z++;
                                            while(s.charAt(z) != '>')
                                            {
                                                count++;
                                                z++;
                                            }
                                            z++;
                                        }
                                        else
                                        {
                                            output = output + s.charAt(z);
                                            count++;
                                            z++;
                                        }
                                    }
                                output = output + "\n";
                                InternationalNews.append(output, null);
                                value++;

                            }

                        }
                }
		catch(Exception e)
		{
			InternationalNews.append("Server Load high \n Try after sometime ", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|103-getter|2|
        return InternationalNews;
    }
    //</editor-fold>//GEN-END:|103-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: InternationalNewsAction ">//GEN-BEGIN:|103-action|0|103-preAction
    /**
     * Performs an action assigned to the selected list element in the InternationalNews component.
     */
    public void InternationalNewsAction() {//GEN-END:|103-action|0|103-preAction
        // enter pre-action user code here
        String __selectedString = getInternationalNews().getString(getInternationalNews().getSelectedIndex());//GEN-LINE:|103-action|1|103-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|103-action|2|
    //</editor-fold>//GEN-END:|103-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Cinema ">//GEN-BEGIN:|107-getter|0|107-preInit
    /**
     * Returns an initiliazed instance of Cinema component.
     * @return the initialized component instance
     */
    public List getCinema() {
        if (Cinema == null) {//GEN-END:|107-getter|0|107-preInit
            // write pre-init user code here
            Cinema = new List("Cinema", Choice.IMPLICIT);//GEN-BEGIN:|107-getter|1|107-postInit
            Cinema.append("Bollywood", getHolly());
            Cinema.append("Hollywood", getHolly());
            Cinema.addCommand(getBackCommand());
            Cinema.setCommandListener(this);
            Cinema.setSelectedFlags(new boolean[] { false, false });//GEN-END:|107-getter|1|107-postInit

        }//GEN-BEGIN:|107-getter|2|
        return Cinema;
    }
    //</editor-fold>//GEN-END:|107-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: CinemaAction ">//GEN-BEGIN:|107-action|0|107-preAction
    /**
     * Performs an action assigned to the selected list element in the Cinema component.
     */
    public void CinemaAction() {//GEN-END:|107-action|0|107-preAction
        // enter pre-action user code here
        String __selectedString = getCinema().getString(getCinema().getSelectedIndex());//GEN-BEGIN:|107-action|1|197-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Bollywood")) {//GEN-END:|107-action|1|197-preAction
                // write pre-action user code here
                switchDisplayable(null, getBollywood());//GEN-LINE:|107-action|2|197-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Hollywood")) {//GEN-LINE:|107-action|3|198-preAction
                // write pre-action user code here
                switchDisplayable(null, getHollywood());//GEN-LINE:|107-action|4|198-postAction
                // write post-action user code here
            }//GEN-BEGIN:|107-action|5|107-postAction
        }//GEN-END:|107-action|5|107-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|107-action|6|
    //</editor-fold>//GEN-END:|107-action|6|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Gadgets ">//GEN-BEGIN:|113-getter|0|113-preInit
    /**
     * Returns an initiliazed instance of Gadgets component.
     * @return the initialized component instance
     */
    public List getGadgets() {
        if (Gadgets == null) {//GEN-END:|113-getter|0|113-preInit
            // write pre-init user code here
            Gadgets = new List("Gadgets", Choice.IMPLICIT);//GEN-BEGIN:|113-getter|1|113-postInit
            Gadgets.addCommand(getBackCommand());
            Gadgets.addCommand(getSMStofriend1());
            Gadgets.setCommandListener(this);//GEN-END:|113-getter|1|113-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
			Vector rssItems = parser.parse("http://freshgadgetnews.com/feed/");

			for(int i = 0; i < rssItems.size() && i < 10; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i + 1) + " . " +(String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                count = output.length();
                                int z = 0 ;
                                while(z < s.length())
                                {
                                    if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                    {
                                        count++;
                                        z++;
                                        while(s.charAt(z) != '>')
                                        {
                                            count++;
                                            z++;
                                        }
                                        z++;
                                    }
                                    else if(s.charAt(z) == '[')
                                        z = z + 9;
                                    else if(s.charAt(z) == '&')
                                        z = z + 7;
                                    else
                                    {
                                        output = output + s.charAt(z);
                                        count++;
                                        z++;
                                    }
                                }
                                output = output + "\n";
                                Gadgets.append(output, null);
                         }
                }
		catch(Exception e)
		{
			Gadgets.append("Server Load high \n Try after sometime ", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|113-getter|2|
        return Gadgets;
    }
    //</editor-fold>//GEN-END:|113-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: GadgetsAction ">//GEN-BEGIN:|113-action|0|113-preAction
    /**
     * Performs an action assigned to the selected list element in the Gadgets component.
     */
    public void GadgetsAction() {//GEN-END:|113-action|0|113-preAction
        // enter pre-action user code here
        String __selectedString = getGadgets().getString(getGadgets().getSelectedIndex());//GEN-LINE:|113-action|1|113-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|113-action|2|
    //</editor-fold>//GEN-END:|113-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Technology ">//GEN-BEGIN:|116-getter|0|116-preInit
    /**
     * Returns an initiliazed instance of Technology component.
     * @return the initialized component instance
     */
    public List getTechnology() {
        if (Technology == null) {//GEN-END:|116-getter|0|116-preInit
            // write pre-init user code here
            Technology = new List("Technology", Choice.IMPLICIT);//GEN-BEGIN:|116-getter|1|116-postInit
            Technology.addCommand(getBackCommand());
            Technology.addCommand(getSMStofriend1());
            Technology.setCommandListener(this);//GEN-END:|116-getter|1|116-postInit
             KXmlRssParser parser = new KXmlRssParser();
            try
		{
			Technology.append("Tech News \n",null);
                        Vector rssItems = parser.parse("http://feeds.bbci.co.uk/news/technology/rss.xml");
			            int value = 0;

			for(int i = 0; i < rssItems.size() && value < 5 ; i++)
			{
                                String s = (i + 1) + " . " + (String) ((RssItem)rssItems.elementAt(i)).description;
                                s = s + "\n";
                                Technology.append(s, null);
                         }

                        /*Technology.append("\n Hott Gadgets \n",null);*/
                        rssItems = parser.parse("http://timesofindia.feedsportal.com/c/33039/f/533923/index.rss");

			for(int i = 0; i < rssItems.size() && i < 5 ; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i + 1) + " . " +(String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                count = output.length();
                                int z = 0 ;
                                while(z < s.length())
                                {
                                    if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                    {
                                        count++;
                                        z++;
                                        while(s.charAt(z) != '>')
                                        {
                                            count++;
                                            z++;
                                        }
                                        z++;
                                    }
                                    else
                                    {
                                        output = output + s.charAt(z);
                                        count++;
                                        z++;
                                    }
                                }
                                output = output + "\n";
                                Technology.append(output, null);
								value++;
                         }
                }
		catch(Exception e)
		{
			Technology.append("Server Load high \n Try after sometime ", null);
			e.printStackTrace();
		}
        }//GEN-BEGIN:|116-getter|2|
        return Technology;
    }
    //</editor-fold>//GEN-END:|116-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: TechnologyAction ">//GEN-BEGIN:|116-action|0|116-preAction
    /**
     * Performs an action assigned to the selected list element in the Technology component.
     */
    public void TechnologyAction() {//GEN-END:|116-action|0|116-preAction
        // enter pre-action user code here
        String __selectedString = getTechnology().getString(getTechnology().getSelectedIndex());//GEN-LINE:|116-action|1|116-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|116-action|2|
    //</editor-fold>//GEN-END:|116-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Sports ">//GEN-BEGIN:|122-getter|0|122-preInit
    /**
     * Returns an initiliazed instance of Sports component.
     * @return the initialized component instance
     */
    public List getSports() {
        if (Sports == null) {//GEN-END:|122-getter|0|122-preInit
            // write pre-init user code here
            Sports = new List("Sports", Choice.IMPLICIT);//GEN-BEGIN:|122-getter|1|122-postInit
            Sports.append("Cricket", getCric());
            Sports.append("Football", getFoot());
            Sports.append("Basketball", getBasket());
            Sports.append("Tennis", getTennis1());
            Sports.append("Baseball", getBase());
            Sports.append("Golf", getGolfpic());
            Sports.append("Rugby", getRugby1());
            Sports.append("Hockey", getHockey1());
            Sports.append("F1 racing", getF2());
            Sports.append("MotoGP racing", getMoto());
            Sports.addCommand(getBackCommand());
            Sports.setCommandListener(this);
            Sports.setSelectedFlags(new boolean[] { false, false, false, false, false, false, false, false, false, false });//GEN-END:|122-getter|1|122-postInit
            // write post-init user code here
        }//GEN-BEGIN:|122-getter|2|
        return Sports;
    }
    //</editor-fold>//GEN-END:|122-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: SportsAction ">//GEN-BEGIN:|122-action|0|122-preAction
    /**
     * Performs an action assigned to the selected list element in the Sports component.
     */
    public void SportsAction() {//GEN-END:|122-action|0|122-preAction
        // enter pre-action user code here
        String __selectedString = getSports().getString(getSports().getSelectedIndex());//GEN-BEGIN:|122-action|1|179-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Cricket")) {//GEN-END:|122-action|1|179-preAction
                // write pre-action user code here
                switchDisplayable(null, getCricket());//GEN-LINE:|122-action|2|179-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Football")) {//GEN-LINE:|122-action|3|181-preAction
                // write pre-action user code here
                switchDisplayable(null, getFootball());//GEN-LINE:|122-action|4|181-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Basketball")) {//GEN-LINE:|122-action|5|180-preAction
                // write pre-action user code here
                switchDisplayable(null, getBasketball());//GEN-LINE:|122-action|6|180-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Tennis")) {//GEN-LINE:|122-action|7|182-preAction
                // write pre-action user code here
                switchDisplayable(null, getTennis());//GEN-LINE:|122-action|8|182-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Baseball")) {//GEN-LINE:|122-action|9|183-preAction
                // write pre-action user code here
                switchDisplayable(null, getBaseball());//GEN-LINE:|122-action|10|183-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Golf")) {//GEN-LINE:|122-action|11|184-preAction
                // write pre-action user code here
                switchDisplayable(null, getGolf());//GEN-LINE:|122-action|12|184-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Rugby")) {//GEN-LINE:|122-action|13|219-preAction
                // write pre-action user code here
                switchDisplayable(null, getRugby());//GEN-LINE:|122-action|14|219-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Hockey")) {//GEN-LINE:|122-action|15|220-preAction
                // write pre-action user code here
                switchDisplayable(null, getHockey());//GEN-LINE:|122-action|16|220-postAction
                // write post-action user code here
            } else if (__selectedString.equals("F1 racing")) {//GEN-LINE:|122-action|17|221-preAction
                // write pre-action user code here
                switchDisplayable(null, getF1());//GEN-LINE:|122-action|18|221-postAction
                // write post-action user code here
            } else if (__selectedString.equals("MotoGP racing")) {//GEN-LINE:|122-action|19|322-preAction
                // write pre-action user code here
                switchDisplayable(null, getMotoGP());//GEN-LINE:|122-action|20|322-postAction
                // write post-action user code here
            }//GEN-BEGIN:|122-action|21|122-postAction
        }//GEN-END:|122-action|21|122-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|122-action|22|
    //</editor-fold>//GEN-END:|122-action|22|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: BusinessStats ">//GEN-BEGIN:|125-getter|0|125-preInit
    /**
     * Returns an initiliazed instance of BusinessStats component.
     * @return the initialized component instance
     */
    public List getBusinessStats() {
        if (BusinessStats == null) {//GEN-END:|125-getter|0|125-preInit
            // write pre-init user code here
            BusinessStats = new List("Business stats", Choice.IMPLICIT);//GEN-BEGIN:|125-getter|1|125-postInit
            BusinessStats.addCommand(getBackCommand());
            BusinessStats.addCommand(getSMStofriend1());
            BusinessStats.setCommandListener(this);//GEN-END:|125-getter|1|125-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
			BusinessStats.append("Commodity headlines \n",null);
                        Vector rssItems = parser.parse("http://commodityonline.com/rssfeed/cmdtytrends_rss.xml");

			for(int i = 0; i < rssItems.size(); i++)
			{

                                    String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                    String output = null;
                                    int count = 0;
                                    while(count < s.length())
                                    {
                                        System.out.println("Inside while" +count);
                                        if(s.charAt(count) == '<')
                                        {
                                            count++;
                                            while(s.charAt(count) != '>')
                                                count++;
                                            count++;
                                        }
                                        else
                                        {
                                            if(output != null )
                                                output = output + s.charAt(count);
                                            else output = " " + s.charAt(count);
                                            count++;
                                        }
                                    }
                                    BusinessStats.append(output + "\n", null);

                        }
              }
              catch(Exception e)
              {
                         BusinessStats.append("Server Load high \n Try after sometime ", null);
                         e.printStackTrace();
              }
        }//GEN-BEGIN:|125-getter|2|
        return BusinessStats;
    }
    //</editor-fold>//GEN-END:|125-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: BusinessStatsAction ">//GEN-BEGIN:|125-action|0|125-preAction
    /**
     * Performs an action assigned to the selected list element in the BusinessStats component.
     */
    public void BusinessStatsAction() {//GEN-END:|125-action|0|125-preAction
        // enter pre-action user code here
        String __selectedString = getBusinessStats().getString(getBusinessStats().getSelectedIndex());//GEN-LINE:|125-action|1|125-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|125-action|2|
    //</editor-fold>//GEN-END:|125-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Stocks ">//GEN-BEGIN:|128-getter|0|128-preInit
    /**
     * Returns an initiliazed instance of Stocks component.
     * @return the initialized component instance
     */
    public List getStocks() {
        if (Stocks == null) {//GEN-END:|128-getter|0|128-preInit
            // write pre-init user code here
            Stocks = new List("Stocks", Choice.IMPLICIT);//GEN-BEGIN:|128-getter|1|128-postInit
            Stocks.addCommand(getBackCommand());
            Stocks.addCommand(getSMStofriend1());
            Stocks.setCommandListener(this);//GEN-END:|128-getter|1|128-postInit
            Stocks.append("World Stock Market News \n",null);
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
			Vector rssItems = parser.parse("http://utvmoney.mangopeople.com/rss/rss.php?f=world");

			for(int i = 0; i < rssItems.size() && i < 10; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i + 1) + " . " + (String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                count = output.length();
                                int z = 0 ;
                                while(z < s.length())
                                {
                                    if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                    {
                                        count++;
                                        z++;
                                        while(s.charAt(z) != '>')
                                        {
                                            count++;
                                            z++;
                                        }
                                        z++;
                                    }
                                    else
                                    {
                                        output = output + s.charAt(z);
                                        count++;
                                        z++;
                                    }
                                }
                                output = output + "\n";
                                Stocks.append(output, null);
                         }
                }
		catch(Exception e)
		{
			Stocks.append("Server Load high \n Try after sometime ", null);
			e.printStackTrace();
		}
        }//GEN-BEGIN:|128-getter|2|
        return Stocks;
    }
    //</editor-fold>//GEN-END:|128-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: StocksAction ">//GEN-BEGIN:|128-action|0|128-preAction
    /**
     * Performs an action assigned to the selected list element in the Stocks component.
     */
    public void StocksAction() {//GEN-END:|128-action|0|128-preAction
        // enter pre-action user code here
        String __selectedString = getStocks().getString(getStocks().getSelectedIndex());//GEN-LINE:|128-action|1|128-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|128-action|2|
    //</editor-fold>//GEN-END:|128-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: NationalNews ">//GEN-BEGIN:|133-getter|0|133-preInit
    /**
     * Returns an initiliazed instance of NationalNews component.
     * @return the initialized component instance
     */
    public List getNationalNews() {
        if (NationalNews == null) {//GEN-END:|133-getter|0|133-preInit
            // write pre-init user code here
            NationalNews = new List("National News", Choice.IMPLICIT);//GEN-BEGIN:|133-getter|1|133-postInit
            NationalNews.addCommand(getBackCommand());
            NationalNews.addCommand(getSMStofriend1());
            NationalNews.setCommandListener(this);//GEN-END:|133-getter|1|133-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
			{

                        String fee = "http://feeds.bbci.co.uk/news/world/" + nationva[nation] +"/rss.xml";
                        Vector rssItems = parser.parse(fee);
						int value = 0;

				for(int i = 0; i < rssItems.size() && value < 10; i++)
				{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                count = output.length();
                                int z = 0 ;
								if(output.substring(0,5).equals("VIDEO"))
                                {
                                }
                                else
                                {
									while(z < s.length())
									{
										if(s.charAt(z) == '<' || s.charAt(z) == '\n')
										{
											z++;
											while(s.charAt(z) != '>')
											{
												z++;
											}
											z++;
										}
										else
										{
											output = output + s.charAt(z);
											count++;
											z++;
										}
									}
									output = output + "\n";
									NationalNews.append(output, null);
									value++;
								}
                    }
                }
		catch(Exception e)
		{
			NationalNews.append("Server Load high \n Try after sometime ", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|133-getter|2|
        return NationalNews;
    }
    //</editor-fold>//GEN-END:|133-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: NationalNewsAction ">//GEN-BEGIN:|133-action|0|133-preAction
    /**
     * Performs an action assigned to the selected list element in the NationalNews component.
     */
    public void NationalNewsAction() {//GEN-END:|133-action|0|133-preAction
        // enter pre-action user code here
        String __selectedString = getNationalNews().getString(getNationalNews().getSelectedIndex());//GEN-LINE:|133-action|1|133-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|133-action|2|
    //</editor-fold>//GEN-END:|133-action|2|
    //</editor-fold>
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: feedspic ">//GEN-BEGIN:|167-getter|0|167-preInit
    /**
     * Returns an initiliazed instance of feedspic component.
     * @return the initialized component instance
     */
    public Image getFeedspic() {
        if (feedspic == null) {//GEN-END:|167-getter|0|167-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|167-getter|1|167-@java.io.IOException
                feedspic = Image.createImage("");
            } catch (java.io.IOException e) {//GEN-END:|167-getter|1|167-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|167-getter|2|167-postInit
            // write post-init user code here
        }//GEN-BEGIN:|167-getter|3|
        return feedspic;
    }
    //</editor-fold>//GEN-END:|167-getter|3|
    //</editor-fold>
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: configpic ">//GEN-BEGIN:|168-getter|0|168-preInit
    /**
     * Returns an initiliazed instance of configpic component.
     * @return the initialized component instance
     */
    public Image getConfigpic() {
        if (configpic == null) {//GEN-END:|168-getter|0|168-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|168-getter|1|168-@java.io.IOException
                configpic = Image.createImage("/configure.png");
            } catch (java.io.IOException e) {//GEN-END:|168-getter|1|168-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|168-getter|2|168-postInit
            // write post-init user code here
        }//GEN-BEGIN:|168-getter|3|
        return configpic;
    }
    //</editor-fold>//GEN-END:|168-getter|3|
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: helppic ">//GEN-BEGIN:|169-getter|0|169-preInit
    /**
     * Returns an initiliazed instance of helppic component.
     * @return the initialized component instance
     */
    public Image getHelppic() {
        if (helppic == null) {//GEN-END:|169-getter|0|169-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|169-getter|1|169-@java.io.IOException
                helppic = Image.createImage("/help.png");
            } catch (java.io.IOException e) {//GEN-END:|169-getter|1|169-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|169-getter|2|169-postInit
            // write post-init user code here
        }//GEN-BEGIN:|169-getter|3|
        return helppic;
    }
    //</editor-fold>//GEN-END:|169-getter|3|
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: creditpic ">//GEN-BEGIN:|170-getter|0|170-preInit
    /**
     * Returns an initiliazed instance of creditpic component.
     * @return the initialized component instance
     */
    public Image getCreditpic() {
        if (creditpic == null) {//GEN-END:|170-getter|0|170-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|170-getter|1|170-@java.io.IOException
                creditpic = Image.createImage("/credits.png");
            } catch (java.io.IOException e) {//GEN-END:|170-getter|1|170-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|170-getter|2|170-postInit
            // write post-init user code here
        }//GEN-BEGIN:|170-getter|3|
        return creditpic;
    }
    //</editor-fold>//GEN-END:|170-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: task ">//GEN-BEGIN:|178-getter|0|178-preInit
    /**
     * Returns an initiliazed instance of task component.
     * @return the initialized component instance
     */
    public SimpleCancellableTask getTask() {
        if (task == null) {//GEN-END:|178-getter|0|178-preInit
            // write pre-init user code here
            task = new SimpleCancellableTask();//GEN-BEGIN:|178-getter|1|178-execute
            task.setExecutable(new org.netbeans.microedition.util.Executable() {
                public void execute() throws Exception {//GEN-END:|178-getter|1|178-execute
                    // write task-execution user code here
                }//GEN-BEGIN:|178-getter|2|178-postInit
            });//GEN-END:|178-getter|2|178-postInit
            // write post-init user code here
        }//GEN-BEGIN:|178-getter|3|
        return task;
    }
    //</editor-fold>//GEN-END:|178-getter|3|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Cricket ">//GEN-BEGIN:|185-getter|0|185-preInit
    /**
     * Returns an initiliazed instance of Cricket component.
     * @return the initialized component instance
     */
    public List getCricket() {
        if (Cricket == null) {//GEN-END:|185-getter|0|185-preInit
            // write pre-init user code here
            Cricket = new List("Cricket", Choice.IMPLICIT);//GEN-BEGIN:|185-getter|1|185-postInit
            Cricket.addCommand(getBackCommand4());
            Cricket.addCommand(getSMStofriend1());
            Cricket.setCommandListener(this);//GEN-END:|185-getter|1|185-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
			Cricket.append("Live score card \n",null);
                        Vector rssItems = parser.parse("http://static.espncricinfo.com/rss/livescores.xml");

			for(int i = 0; i < rssItems.size() ; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                Cricket.append(s, null);
                         }

                        Cricket.append("\n News \n",null);
                        rssItems = parser.parse("http://www.espncricinfo.com/rss/content/story/feeds/0.xml");

			for(int i = 0; i < rssItems.size() && i < 5 ; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i + 1) + " . " +(String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                count = output.length();
                                int z = 0 ;
                                while(z < s.length())
                                {
                                    if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                    {
                                        count++;
                                        z++;
                                        while(s.charAt(z) != '>')
                                        {
                                            count++;
                                            z++;
                                        }
                                        z++;
                                    }
                                    else
                                    {
                                        output = output + s.charAt(z);
                                        count++;
                                        z++;
                                    }
                                }
                                output = output + "\n";
                                Cricket.append(output, null);
                         }
                }
		catch(Exception e)
		{
			Cricket.append("Server Load high \n Try after sometime ", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|185-getter|2|
        return Cricket;
    }
    //</editor-fold>//GEN-END:|185-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: CricketAction ">//GEN-BEGIN:|185-action|0|185-preAction
    /**
     * Performs an action assigned to the selected list element in the Cricket component.
     */
    public void CricketAction() {//GEN-END:|185-action|0|185-preAction
        // enter pre-action user code here
        String __selectedString = getCricket().getString(getCricket().getSelectedIndex());//GEN-LINE:|185-action|1|185-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|185-action|2|
    //</editor-fold>//GEN-END:|185-action|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Football ">//GEN-BEGIN:|188-getter|0|188-preInit
    /**
     * Returns an initiliazed instance of Football component.
     * @return the initialized component instance
     */
    public List getFootball() {
        if (Football == null) {//GEN-END:|188-getter|0|188-preInit
            // write pre-init user code here
            Football = new List("Football", Choice.IMPLICIT);//GEN-BEGIN:|188-getter|1|188-postInit
            Football.addCommand(getBackCommand5());
            Football.addCommand(getSMStofriend1());
            Football.setCommandListener(this);//GEN-END:|188-getter|1|188-postInit
           KXmlRssParser parser = new KXmlRssParser();
            try
		{
			Football.append("News \n",null);
                        Vector rssItems = parser.parse("http://soccernet.espn.go.com/rss/news");

			for(int i = 0; i < rssItems.size() && i < 5; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i + 1) + " . " +(String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                count = output.length();
                                int z = 0 ;
                                while(z < s.length())
                                {
                                    if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                    {
                                        count++;
                                        z++;
                                        while(s.charAt(z) != '>')
                                        {
                                            count++;
                                            z++;
                                        }
                                        z++;
                                    }
                                    else
                                    {
                                        output = output + s.charAt(z);
                                        count++;
                                        z++;
                                    }
                                }
                                output = output + "\n";
                                Football.append(output, null);
                         }
                }
		catch(Exception e)
		{
			Football.append("Server Load high \n Try after sometime ", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|188-getter|2|
        return Football;
    }
    //</editor-fold>//GEN-END:|188-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: FootballAction ">//GEN-BEGIN:|188-action|0|188-preAction
    /**
     * Performs an action assigned to the selected list element in the Football component.
     */
    public void FootballAction() {//GEN-END:|188-action|0|188-preAction
        // enter pre-action user code here
        String __selectedString = getFootball().getString(getFootball().getSelectedIndex());//GEN-LINE:|188-action|1|188-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|188-action|2|
    //</editor-fold>//GEN-END:|188-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Basketball ">//GEN-BEGIN:|193-getter|0|193-preInit
    /**
     * Returns an initiliazed instance of Basketball component.
     * @return the initialized component instance
     */
    public List getBasketball() {
        if (Basketball == null) {//GEN-END:|193-getter|0|193-preInit
            // write pre-init user code here
            Basketball = new List("Basketball", Choice.IMPLICIT);//GEN-BEGIN:|193-getter|1|193-postInit
            Basketball.addCommand(getBackCommand());
            Basketball.addCommand(getSMStofriend1());
            Basketball.setCommandListener(this);//GEN-END:|193-getter|1|193-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
			Basketball.append("Live score card \n",null);
                        Vector rssItems = parser.parse("http://www.scorespro.com/rss/live-basketball.xml");

			for(int i = 0; i < rssItems.size() && i < 5 ; i++)
			{
                                String s = (i + 1) + " . " +(String) ((RssItem)rssItems.elementAt(i)).title;
                                Basketball.append(s, null);
                         }

                        Basketball.append("\n News \n",null);
                        rssItems = parser.parse("http://sports.espn.go.com/espn/rss/nba/news");

			for(int i = 0; i < rssItems.size() && i < 5; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i + 1) + " . " +(String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                count = output.length();
                                int z = 0 ;
                                while(z < s.length())
                                {
                                    if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                    {
                                        count++;
                                        z++;
                                        while(s.charAt(z) != '>')
                                        {
                                            count++;
                                            z++;
                                        }
                                        z++;
                                    }
                                    else
                                    {
                                        output = output + s.charAt(z);
                                        count++;
                                        z++;
                                    }
                                }
                                output = output + "\n";
                                Basketball.append(output, null);
                         }
                }
		catch(Exception e)
		{
			Basketball.append("Server Load high \n Try after sometime ", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|193-getter|2|
        return Basketball;
    }
    //</editor-fold>//GEN-END:|193-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: BasketballAction ">//GEN-BEGIN:|193-action|0|193-preAction
    /**
     * Performs an action assigned to the selected list element in the Basketball component.
     */
    public void BasketballAction() {//GEN-END:|193-action|0|193-preAction
        // enter pre-action user code here
        String __selectedString = getBasketball().getString(getBasketball().getSelectedIndex());//GEN-LINE:|193-action|1|193-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|193-action|2|
    //</editor-fold>//GEN-END:|193-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Bollywood ">//GEN-BEGIN:|199-getter|0|199-preInit
    /**
     * Returns an initiliazed instance of Bollywood component.
     * @return the initialized component instance
     */
    public List getBollywood() {
        if (Bollywood == null) {//GEN-END:|199-getter|0|199-preInit
            // write pre-init user code here
            Bollywood = new List("Bollywood", Choice.IMPLICIT);//GEN-BEGIN:|199-getter|1|199-postInit
            Bollywood.addCommand(getBackCommand2());
            Bollywood.addCommand(getSMStofriend1());
            Bollywood.setCommandListener(this);//GEN-END:|199-getter|1|199-postInit
            System.out.println("Help");
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
			Bollywood.append("Movies and release dates :\n ",null);
                        Vector rssItems = parser.parse("http://www.bollywoodhungama.com/rss/release_dates.xml");

			for(int i = 0; i < rssItems.size() && i < 5; i++)
			{
                                String s = (i + 1) + " . " + (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (String) (((RssItem)rssItems.elementAt(i)).title) + "\n   ";
                                count = output.length();
                                int z = 0 ;
                                while(z < s.length())
                                {
                                    if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                    {
                                        z++;
                                        while(s.charAt(z) != '>')
                                        {
                                            z++;
                                        }
                                        z++;
                                    }
                                    else
                                    {
                                        output = output + s.charAt(z);
                                        count++;
                                        z++;
                                    }
                                }
                                Bollywood.append(output, null);
                            }

                        Bollywood.append("\n News updates :\n ",null);
                        rssItems = parser.parse("http://feeds.reuters.com/reuters/INbollywood");

                        for(int i = 0; i < rssItems.size() && i < 5; i++)
                        {
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i + 1) + " . " +(String) (((RssItem)rssItems.elementAt(i)).title) + "\n   ";
                                count = output.length();
                                int z = 0 ;
                                while(z < s.length())
                                {
                                    if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                    {
                                        z++;
                                        while(s.charAt(z) != '>')
                                        {
                                            z++;
                                        }
                                        z++;
                                    }
                                    else
                                    {
                                        output = output + s.charAt(z);
                                        count++;
                                        z++;
                                    }
                                }
                                output = output + "\n";
                                Bollywood.append(output, null);

                         }
                }
		catch(Exception e)
		{
			Bollywood.append("Server Load high \n Try after sometime ", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|199-getter|2|
        return Bollywood;
    }
    //</editor-fold>//GEN-END:|199-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: BollywoodAction ">//GEN-BEGIN:|199-action|0|199-preAction
    /**
     * Performs an action assigned to the selected list element in the Bollywood component.
     */
    public void BollywoodAction() {//GEN-END:|199-action|0|199-preAction
        // enter pre-action user code here
        String __selectedString = getBollywood().getString(getBollywood().getSelectedIndex());//GEN-LINE:|199-action|1|199-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|199-action|2|
    //</editor-fold>//GEN-END:|199-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Hollywood ">//GEN-BEGIN:|202-getter|0|202-preInit
    /**
     * Returns an initiliazed instance of Hollywood component.
     * @return the initialized component instance
     */
    public List getHollywood() {
        if (Hollywood == null) {//GEN-END:|202-getter|0|202-preInit
            // write pre-init user code here
            Hollywood = new List("Hollywood", Choice.IMPLICIT);//GEN-BEGIN:|202-getter|1|202-postInit
            Hollywood.addCommand(getBackCommand3());
            Hollywood.addCommand(getSMStofriend1());
            Hollywood.setCommandListener(this);//GEN-END:|202-getter|1|202-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
			Hollywood.append("Movies and release dates :\n ",null);
                        Vector rssItems = parser.parse("http://rss.ent.yahoo.com/movies/upcoming.xml");

			for(int i = 0; i < rssItems.size() && i < 5; i++)
			{
                                String output = (String) (((RssItem)rssItems.elementAt(i)).title);
                                Hollywood.append(output, null);
                         }

                        Hollywood.append("\n News updates :\n ",null);
                        rssItems = parser.parse("http://www.latimes.com//entertainment/news/rss2.0.xml");

                        for(int i = 0; i < 5; i++)
                            {
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i + 1) + " . " +(String) (((RssItem)rssItems.elementAt(i)).title) + "\n   ";
                                count = output.length();
                                int z = 0 ;
                                while(z < s.length())
                                {
                                    if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                    {
                                        z++;
                                        while(s.charAt(z) != '>')
                                        {
                                            z++;
                                        }
                                        z++;
                                    }
                                    else
                                    {
                                        output = output + s.charAt(z);
                                        count++;
                                        z++;
                                    }
                                }
                              output = output += "\n";
                              Hollywood.append(output, null);
                  }
                }
		catch(Exception e)
		{
			Hollywood.append("Server Load high \n Try after sometime ", null);

			e.printStackTrace();
            }
        }//GEN-BEGIN:|202-getter|2|
        return Hollywood;
    }
    //</editor-fold>//GEN-END:|202-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: HollywoodAction ">//GEN-BEGIN:|202-action|0|202-preAction
    /**
     * Performs an action assigned to the selected list element in the Hollywood component.
     */
    public void HollywoodAction() {//GEN-END:|202-action|0|202-preAction
        // enter pre-action user code here
        String __selectedString = getHollywood().getString(getHollywood().getSelectedIndex());//GEN-LINE:|202-action|1|202-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|202-action|2|
    //</editor-fold>//GEN-END:|202-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Tennis ">//GEN-BEGIN:|207-getter|0|207-preInit
    /**
     * Returns an initiliazed instance of Tennis component.
     * @return the initialized component instance
     */
    public List getTennis() {
        if (Tennis == null) {//GEN-END:|207-getter|0|207-preInit
            // write pre-init user code here
            Tennis = new List("Tennis", Choice.IMPLICIT);//GEN-BEGIN:|207-getter|1|207-postInit
            Tennis.addCommand(getBackCommand());
            Tennis.addCommand(getSMStofriend1());
            Tennis.setCommandListener(this);//GEN-END:|207-getter|1|207-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
			Tennis.append("Live score card \n",null);
                        Vector rssItems = parser.parse("http://newsrss.bbc.co.uk/rss/sportonline_world_edition/tennis/live_scores/rss.xml");

			for(int i = 0; i < rssItems.size() && i < 5 ; i++)
			{
                                String s = (i + 1) + " . " +(String) ((RssItem)rssItems.elementAt(i)).title;
                                Tennis.append(s, null);
                                s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                Tennis.append(s,null);
                         }

                        Tennis.append("\n News \n",null);
                        rssItems = parser.parse("http://sports-ak.espn.go.com/espn/rss/tennis/news");

			for(int i = 0; i < rssItems.size() && i < 5; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i + 1) + " . " +(String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                count = output.length();
                                int z = 0 ;
                                while(z < s.length())
                                {
                                    if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                    {
                                        count++;
                                        z++;
                                        while(s.charAt(z) != '>')
                                        {
                                            count++;
                                            z++;
                                        }
                                        z++;
                                    }
                                    else
                                    {
                                        output = output + s.charAt(z);
                                        count++;
                                        z++;
                                    }
                                }
                                output = output + "\n";
                                Tennis.append(output, null);
                         }
                }
		catch(Exception e)
		{
			Tennis.append("Server Load high \n Try after sometime ", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|207-getter|2|
        return Tennis;
    }
    //</editor-fold>//GEN-END:|207-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: TennisAction ">//GEN-BEGIN:|207-action|0|207-preAction
    /**
     * Performs an action assigned to the selected list element in the Tennis component.
     */
    public void TennisAction() {//GEN-END:|207-action|0|207-preAction
        // enter pre-action user code here
        String __selectedString = getTennis().getString(getTennis().getSelectedIndex());//GEN-LINE:|207-action|1|207-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|207-action|2|
    //</editor-fold>//GEN-END:|207-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Baseball ">//GEN-BEGIN:|210-getter|0|210-preInit
    /**
     * Returns an initiliazed instance of Baseball component.
     * @return the initialized component instance
     */
    public List getBaseball() {
        if (Baseball == null) {//GEN-END:|210-getter|0|210-preInit
            // write pre-init user code here
            Baseball = new List("Baseball", Choice.IMPLICIT);//GEN-BEGIN:|210-getter|1|210-postInit
            Baseball.addCommand(getBackCommand());
            Baseball.addCommand(getSMStofriend1());
            Baseball.setCommandListener(this);//GEN-END:|210-getter|1|210-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
			Baseball.append("Live score card \n",null);
                        Vector rssItems = parser.parse("http://www.scorespro.com/rss/live-soccer.xml");

			for(int i = 0; i < rssItems.size() && i < 5 ; i++)
			{
                                String s = (i + 1) + " . " +(String) ((RssItem)rssItems.elementAt(i)).title;
                                Baseball.append(s, null);
                         }

                        Baseball.append("\n News \n",null);
                        rssItems = parser.parse("http://aol.sportingnews.com/rss/mlb");

			for(int i = 0; i < rssItems.size() && i < 5 ; i++)
			{
                                String output = (String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                Baseball.append(output, null);
                         }
                }
		catch(Exception e)
		{
			Baseball.append("Server Load high \n Try after sometime ", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|210-getter|2|
        return Baseball;
    }
    //</editor-fold>//GEN-END:|210-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: BaseballAction ">//GEN-BEGIN:|210-action|0|210-preAction
    /**
     * Performs an action assigned to the selected list element in the Baseball component.
     */
    public void BaseballAction() {//GEN-END:|210-action|0|210-preAction
        // enter pre-action user code here
        String __selectedString = getBaseball().getString(getBaseball().getSelectedIndex());//GEN-LINE:|210-action|1|210-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|210-action|2|
    //</editor-fold>//GEN-END:|210-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Golf ">//GEN-BEGIN:|215-getter|0|215-preInit
    /**
     * Returns an initiliazed instance of Golf component.
     * @return the initialized component instance
     */
    public List getGolf() {
        if (Golf == null) {//GEN-END:|215-getter|0|215-preInit
            // write pre-init user code here
            Golf = new List("Golf", Choice.IMPLICIT);//GEN-BEGIN:|215-getter|1|215-postInit
            Golf.addCommand(getBackCommand());
            Golf.addCommand(getSMStofriend1());
            Golf.setCommandListener(this);//GEN-END:|215-getter|1|215-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
                        Golf.append(" News \n",null);
                        Vector rssItems = parser.parse("http://sports.espn.go.com/espn/rss/golf/news");

			for(int i = 0; i < rssItems.size() && i < 10; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i + 1) + " . " +(String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                count = output.length();
                                int z = 0 ;
                                while(z < s.length())
                                {
                                    if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                    {
                                        count++;
                                        z++;
                                        while(s.charAt(z) != '>')
                                        {
                                            count++;
                                            z++;
                                        }
                                        z++;
                                    }
                                    else
                                    {
                                        output = output + s.charAt(z);
                                        count++;
                                        z++;
                                    }
                                }
                                output = output + "\n";
                                Golf.append(output, null);
                         }
                }
		catch(Exception e)
		{
			Golf.append("Server Load high \n Try after sometime ", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|215-getter|2|
        return Golf;
    }
    //</editor-fold>//GEN-END:|215-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: GolfAction ">//GEN-BEGIN:|215-action|0|215-preAction
    /**
     * Performs an action assigned to the selected list element in the Golf component.
     */
    public void GolfAction() {//GEN-END:|215-action|0|215-preAction
        // enter pre-action user code here
        String __selectedString = getGolf().getString(getGolf().getSelectedIndex());//GEN-LINE:|215-action|1|215-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|215-action|2|
    //</editor-fold>//GEN-END:|215-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Rugby ">//GEN-BEGIN:|222-getter|0|222-preInit
    /**
     * Returns an initiliazed instance of Rugby component.
     * @return the initialized component instance
     */
    public List getRugby() {
        if (Rugby == null) {//GEN-END:|222-getter|0|222-preInit
            // write pre-init user code here
            Rugby = new List("Rugby", Choice.IMPLICIT);//GEN-BEGIN:|222-getter|1|222-postInit
            Rugby.addCommand(getBackCommand());
            Rugby.addCommand(getSMStofriend1());
            Rugby.setCommandListener(this);//GEN-END:|222-getter|1|222-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
			Rugby.append("Live score card \n",null);
                        Vector rssItems = parser.parse("http://www.scorespro.com/rss/live-soccer.xml");

			for(int i = 0; i < rssItems.size() && i < 5 ; i++)
			{
                                String s = (i + 1) + " . " +(String) ((RssItem)rssItems.elementAt(i)).title;
                                Rugby.append(s, null);
                         }

                        Rugby.append("\n News \n",null);
                        rssItems = parser.parse("http://www.espnscrum.com/rss/rugby/story/feeds/0.rss");

			for(int i = 0; i < rssItems.size() && i < 5; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i + 1) + " . " +(String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                count = output.length();
                                int z = 0 ;
                                while(z < s.length())
                                {
                                    if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                    {
                                        count++;
                                        z++;
                                        while(s.charAt(z) != '>')
                                        {
                                            count++;
                                            z++;
                                        }
                                        z++;
                                    }
                                    else
                                    {
                                        output = output + s.charAt(z);
                                        count++;
                                        z++;
                                    }
                                }
                                output = output + "\n";
                                Rugby.append(output, null);
                         }
                }
		catch(Exception e)
		{
			Rugby.append("Server Load high \n Try after sometime ", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|222-getter|2|
        return Rugby;
    }
    //</editor-fold>//GEN-END:|222-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: RugbyAction ">//GEN-BEGIN:|222-action|0|222-preAction
    /**
     * Performs an action assigned to the selected list element in the Rugby component.
     */
    public void RugbyAction() {//GEN-END:|222-action|0|222-preAction
        // enter pre-action user code here
        String __selectedString = getRugby().getString(getRugby().getSelectedIndex());//GEN-LINE:|222-action|1|222-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|222-action|2|
    //</editor-fold>//GEN-END:|222-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Hockey ">//GEN-BEGIN:|225-getter|0|225-preInit
    /**
     * Returns an initiliazed instance of Hockey component.
     * @return the initialized component instance
     */
    public List getHockey() {
        if (Hockey == null) {//GEN-END:|225-getter|0|225-preInit
            // write pre-init user code here
            Hockey = new List("Hockey", Choice.IMPLICIT);//GEN-BEGIN:|225-getter|1|225-postInit
            Hockey.addCommand(getBackCommand());
            Hockey.addCommand(getSMStofriend1());
            Hockey.setCommandListener(this);//GEN-END:|225-getter|1|225-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
			Hockey.append("News \n",null);
                        Vector rssItems = parser.parse("http://newsrss.bbc.co.uk/rss/sportonline_world_edition/other_sports/hockey/rss.xml");

			for(int i = 0; i < rssItems.size() && i < 5; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i + 1) + " . " + (String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                count = output.length();
                                int z = 0 ;
                                while(z < s.length())
                                {
                                    if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                    {
                                        count++;
                                        z++;
                                        while(s.charAt(z) != '>')
                                        {
                                            count++;
                                            z++;
                                        }
                                        z++;
                                    }
                                    else
                                    {
                                        output = output + s.charAt(z);
                                        count++;
                                        z++;
                                    }
                                }
                                output = output + "\n";
                                Hockey.append(output, null);
                         }
                }
		catch(Exception e)
		{
			Hockey.append("Server Load high \n Try after sometime ", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|225-getter|2|
        return Hockey;
    }
    //</editor-fold>//GEN-END:|225-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: HockeyAction ">//GEN-BEGIN:|225-action|0|225-preAction
    /**
     * Performs an action assigned to the selected list element in the Hockey component.
     */
    public void HockeyAction() {//GEN-END:|225-action|0|225-preAction
        // enter pre-action user code here
        String __selectedString = getHockey().getString(getHockey().getSelectedIndex());//GEN-LINE:|225-action|1|225-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|225-action|2|
    //</editor-fold>//GEN-END:|225-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: F1 ">//GEN-BEGIN:|228-getter|0|228-preInit
    /**
     * Returns an initiliazed instance of F1 component.
     * @return the initialized component instance
     */
    public List getF1() {
        if (F1 == null) {//GEN-END:|228-getter|0|228-preInit
            // write pre-init user code here
            F1 = new List("F1", Choice.IMPLICIT);//GEN-BEGIN:|228-getter|1|228-postInit
            F1.addCommand(getBackCommand());
            F1.addCommand(getSMStofriend1());
            F1.setCommandListener(this);//GEN-END:|228-getter|1|228-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
			F1.append("Live score card \n",null);
                        Vector rssItems = parser.parse("http://newsrss.bbc.co.uk/rss/sportonline_world_edition/motorsport/formula_one/results/rss.xml");

			for(int i = 0; i < rssItems.size() && i < 5 ; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                F1.append(s, null);
                         }

                        F1.append("\n News \n",null);
                        rssItems = parser.parse("http://newsrss.bbc.co.uk/rss/sportonline_world_edition/motorsport/formula_one/rss.xml");

			for(int i = 0; i < rssItems.size() && i < 5 ; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i + 1) + " . " +(String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                count = output.length();
                                int z = 0 ;
                                while(z < s.length())
                                {
                                    if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                    {
                                        count++;
                                        z++;
                                        while(s.charAt(z) != '>')
                                        {
                                            count++;
                                            z++;
                                        }
                                        z++;
                                    }
                                    else
                                    {
                                        output = output + s.charAt(z);
                                        count++;
                                        z++;
                                    }
                                }
                                output = output + "\n";
                                F1.append(output, null);
                         }
                }
		catch(Exception e)
		{
			F1.append("Server Load high \n Try after sometime ", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|228-getter|2|
        return F1;
    }
    //</editor-fold>//GEN-END:|228-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: F1Action ">//GEN-BEGIN:|228-action|0|228-preAction
    /**
     * Performs an action assigned to the selected list element in the F1 component.
     */
    public void F1Action() {//GEN-END:|228-action|0|228-preAction
        // enter pre-action user code here
        String __selectedString = getF1().getString(getF1().getSelectedIndex());//GEN-LINE:|228-action|1|228-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|228-action|2|
    //</editor-fold>//GEN-END:|228-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand2 ">//GEN-BEGIN:|234-getter|0|234-preInit
    /**
     * Returns an initiliazed instance of backCommand2 component.
     * @return the initialized component instance
     */
    public Command getBackCommand2() {
        if (backCommand2 == null) {//GEN-END:|234-getter|0|234-preInit
            // write pre-init user code here
            backCommand2 = new Command("Back", Command.BACK, 0);//GEN-LINE:|234-getter|1|234-postInit
            // write post-init user code here
        }//GEN-BEGIN:|234-getter|2|
        return backCommand2;
    }
    //</editor-fold>//GEN-END:|234-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand3 ">//GEN-BEGIN:|236-getter|0|236-preInit
    /**
     * Returns an initiliazed instance of backCommand3 component.
     * @return the initialized component instance
     */
    public Command getBackCommand3() {
        if (backCommand3 == null) {//GEN-END:|236-getter|0|236-preInit
            // write pre-init user code here
            backCommand3 = new Command("Back", Command.BACK, 0);//GEN-LINE:|236-getter|1|236-postInit
            // write post-init user code here
        }//GEN-BEGIN:|236-getter|2|
        return backCommand3;
    }
    //</editor-fold>//GEN-END:|236-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand4 ">//GEN-BEGIN:|240-getter|0|240-preInit
    /**
     * Returns an initiliazed instance of backCommand4 component.
     * @return the initialized component instance
     */
    public Command getBackCommand4() {
        if (backCommand4 == null) {//GEN-END:|240-getter|0|240-preInit
            // write pre-init user code here
            backCommand4 = new Command("Back", Command.BACK, 0);//GEN-LINE:|240-getter|1|240-postInit
            // write post-init user code here
        }//GEN-BEGIN:|240-getter|2|
        return backCommand4;
    }
    //</editor-fold>//GEN-END:|240-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand5 ">//GEN-BEGIN:|243-getter|0|243-preInit
    /**
     * Returns an initiliazed instance of backCommand5 component.
     * @return the initialized component instance
     */
    public Command getBackCommand5() {
        if (backCommand5 == null) {//GEN-END:|243-getter|0|243-preInit
            // write pre-init user code here
            backCommand5 = new Command("Back", Command.BACK, 0);//GEN-LINE:|243-getter|1|243-postInit
            // write post-init user code here
        }//GEN-BEGIN:|243-getter|2|
        return backCommand5;
    }
    //</editor-fold>//GEN-END:|243-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cric ">//GEN-BEGIN:|260-getter|0|260-preInit
    /**
     * Returns an initiliazed instance of cric component.
     * @return the initialized component instance
     */
    public Image getCric() {
        if (cric == null) {//GEN-END:|260-getter|0|260-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|260-getter|1|260-@java.io.IOException
                cric = Image.createImage("/cricket.png");
            } catch (java.io.IOException e) {//GEN-END:|260-getter|1|260-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|260-getter|2|260-postInit
            // write post-init user code here
        }//GEN-BEGIN:|260-getter|3|
        return cric;
    }
    //</editor-fold>//GEN-END:|260-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: foot ">//GEN-BEGIN:|261-getter|0|261-preInit
    /**
     * Returns an initiliazed instance of foot component.
     * @return the initialized component instance
     */
    public Image getFoot() {
        if (foot == null) {//GEN-END:|261-getter|0|261-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|261-getter|1|261-@java.io.IOException
                foot = Image.createImage("/soccer.png");
            } catch (java.io.IOException e) {//GEN-END:|261-getter|1|261-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|261-getter|2|261-postInit
            // write post-init user code here
        }//GEN-BEGIN:|261-getter|3|
        return foot;
    }
    //</editor-fold>//GEN-END:|261-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tennis1 ">//GEN-BEGIN:|262-getter|0|262-preInit
    /**
     * Returns an initiliazed instance of tennis1 component.
     * @return the initialized component instance
     */
    public Image getTennis1() {
        if (tennis1 == null) {//GEN-END:|262-getter|0|262-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|262-getter|1|262-@java.io.IOException
                tennis1 = Image.createImage("/tennis.png");
            } catch (java.io.IOException e) {//GEN-END:|262-getter|1|262-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|262-getter|2|262-postInit
            // write post-init user code here
        }//GEN-BEGIN:|262-getter|3|
        return tennis1;
    }
    //</editor-fold>//GEN-END:|262-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: base ">//GEN-BEGIN:|263-getter|0|263-preInit
    /**
     * Returns an initiliazed instance of base component.
     * @return the initialized component instance
     */
    public Image getBase() {
        if (base == null) {//GEN-END:|263-getter|0|263-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|263-getter|1|263-@java.io.IOException
                base = Image.createImage("/base.png");
            } catch (java.io.IOException e) {//GEN-END:|263-getter|1|263-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|263-getter|2|263-postInit
            // write post-init user code here
        }//GEN-BEGIN:|263-getter|3|
        return base;
    }
    //</editor-fold>//GEN-END:|263-getter|3|
    //</editor-fold>



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: f2 ">//GEN-BEGIN:|265-getter|0|265-preInit
    /**
     * Returns an initiliazed instance of f2 component.
     * @return the initialized component instance
     */
    public Image getF2() {
        if (f2 == null) {//GEN-END:|265-getter|0|265-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|265-getter|1|265-@java.io.IOException
                f2 = Image.createImage("/f1.png");
            } catch (java.io.IOException e) {//GEN-END:|265-getter|1|265-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|265-getter|2|265-postInit
            // write post-init user code here
        }//GEN-BEGIN:|265-getter|3|
        return f2;
    }
    //</editor-fold>//GEN-END:|265-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: hockey1 ">//GEN-BEGIN:|266-getter|0|266-preInit
    /**
     * Returns an initiliazed instance of hockey1 component.
     * @return the initialized component instance
     */
    public Image getHockey1() {
        if (hockey1 == null) {//GEN-END:|266-getter|0|266-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|266-getter|1|266-@java.io.IOException
                hockey1 = Image.createImage("/hockey.png");
            } catch (java.io.IOException e) {//GEN-END:|266-getter|1|266-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|266-getter|2|266-postInit
            // write post-init user code here
        }//GEN-BEGIN:|266-getter|3|
        return hockey1;
    }
    //</editor-fold>//GEN-END:|266-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: rugby1 ">//GEN-BEGIN:|267-getter|0|267-preInit
    /**
     * Returns an initiliazed instance of rugby1 component.
     * @return the initialized component instance
     */
    public Image getRugby1() {
        if (rugby1 == null) {//GEN-END:|267-getter|0|267-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|267-getter|1|267-@java.io.IOException
                rugby1 = Image.createImage("/rugby.png");
            } catch (java.io.IOException e) {//GEN-END:|267-getter|1|267-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|267-getter|2|267-postInit
            // write post-init user code here
        }//GEN-BEGIN:|267-getter|3|
        return rugby1;
    }
    //</editor-fold>//GEN-END:|267-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: basket ">//GEN-BEGIN:|268-getter|0|268-preInit
    /**
     * Returns an initiliazed instance of basket component.
     * @return the initialized component instance
     */
    public Image getBasket() {
        if (basket == null) {//GEN-END:|268-getter|0|268-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|268-getter|1|268-@java.io.IOException
                basket = Image.createImage("/basket.png");
            } catch (java.io.IOException e) {//GEN-END:|268-getter|1|268-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|268-getter|2|268-postInit
            // write post-init user code here
        }//GEN-BEGIN:|268-getter|3|
        return basket;
    }
    //</editor-fold>//GEN-END:|268-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: inter ">//GEN-BEGIN:|269-getter|0|269-preInit
    /**
     * Returns an initiliazed instance of inter component.
     * @return the initialized component instance
     */
    public Image getInter() {
        if (inter == null) {//GEN-END:|269-getter|0|269-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|269-getter|1|269-@java.io.IOException
                inter = Image.createImage("/inter.png");
            } catch (java.io.IOException e) {//GEN-END:|269-getter|1|269-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|269-getter|2|269-postInit
            // write post-init user code here
        }//GEN-BEGIN:|269-getter|3|
        return inter;
    }
    //</editor-fold>//GEN-END:|269-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: national ">//GEN-BEGIN:|270-getter|0|270-preInit
    /**
     * Returns an initiliazed instance of national component.
     * @return the initialized component instance
     */
    public Image getNational() {
        if (national == null) {//GEN-END:|270-getter|0|270-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|270-getter|1|270-@java.io.IOException
                national = Image.createImage("/nation.png");
            } catch (java.io.IOException e) {//GEN-END:|270-getter|1|270-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|270-getter|2|270-postInit
            // write post-init user code here
        }//GEN-BEGIN:|270-getter|3|
        return national;
    }
    //</editor-fold>//GEN-END:|270-getter|3|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cinema2 ">//GEN-BEGIN:|271-getter|0|271-preInit
    /**
     * Returns an initiliazed instance of cinema2 component.
     * @return the initialized component instance
     */
    public Image getCinema2() {
        if (cinema2 == null) {//GEN-END:|271-getter|0|271-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|271-getter|1|271-@java.io.IOException
                cinema2 = Image.createImage("/cinema.png");
            } catch (java.io.IOException e) {//GEN-END:|271-getter|1|271-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|271-getter|2|271-postInit
            // write post-init user code here
        }//GEN-BEGIN:|271-getter|3|
        return cinema2;
    }
    //</editor-fold>//GEN-END:|271-getter|3|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: sports2 ">//GEN-BEGIN:|272-getter|0|272-preInit
    /**
     * Returns an initiliazed instance of sports2 component.
     * @return the initialized component instance
     */
    public Image getSports2() {
        if (sports2 == null) {//GEN-END:|272-getter|0|272-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|272-getter|1|272-@java.io.IOException
                sports2 = Image.createImage("/sports.png");
            } catch (java.io.IOException e) {//GEN-END:|272-getter|1|272-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|272-getter|2|272-postInit
            // write post-init user code here
        }//GEN-BEGIN:|272-getter|3|
        return sports2;
    }
    //</editor-fold>//GEN-END:|272-getter|3|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: art ">//GEN-BEGIN:|273-getter|0|273-preInit
    /**
     * Returns an initiliazed instance of art component.
     * @return the initialized component instance
     */
    public Image getArt() {
        if (art == null) {//GEN-END:|273-getter|0|273-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|273-getter|1|273-@java.io.IOException
                art = Image.createImage("/arts.png");
            } catch (java.io.IOException e) {//GEN-END:|273-getter|1|273-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|273-getter|2|273-postInit
            // write post-init user code here
        }//GEN-BEGIN:|273-getter|3|
        return art;
    }
    //</editor-fold>//GEN-END:|273-getter|3|
    //</editor-fold>


    //</editor-fold>





    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: business ">//GEN-BEGIN:|277-getter|0|277-preInit
    /**
     * Returns an initiliazed instance of business component.
     * @return the initialized component instance
     */
    public Image getBusiness() {
        if (business == null) {//GEN-END:|277-getter|0|277-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|277-getter|1|277-@java.io.IOException
                business = Image.createImage("/business.png");
            } catch (java.io.IOException e) {//GEN-END:|277-getter|1|277-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|277-getter|2|277-postInit
            // write post-init user code here
        }//GEN-BEGIN:|277-getter|3|
        return business;
    }
    //</editor-fold>//GEN-END:|277-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stocks1 ">//GEN-BEGIN:|278-getter|0|278-preInit
    /**
     * Returns an initiliazed instance of stocks1 component.
     * @return the initialized component instance
     */
    public Image getStocks1() {
        if (stocks1 == null) {//GEN-END:|278-getter|0|278-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|278-getter|1|278-@java.io.IOException
                stocks1 = Image.createImage("/stock.png");
            } catch (java.io.IOException e) {//GEN-END:|278-getter|1|278-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|278-getter|2|278-postInit
            // write post-init user code here
        }//GEN-BEGIN:|278-getter|3|
        return stocks1;
    }
    //</editor-fold>//GEN-END:|278-getter|3|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: holly ">//GEN-BEGIN:|280-getter|0|280-preInit
    /**
     * Returns an initiliazed instance of holly component.
     * @return the initialized component instance
     */
    public Image getHolly() {
        if (holly == null) {//GEN-END:|280-getter|0|280-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|280-getter|1|280-@java.io.IOException
                holly = Image.createImage("/holly.png");
            } catch (java.io.IOException e) {//GEN-END:|280-getter|1|280-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|280-getter|2|280-postInit
            // write post-init user code here
        }//GEN-BEGIN:|280-getter|3|
        return holly;
    }
    //</editor-fold>//GEN-END:|280-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ArtsBooks ">//GEN-BEGIN:|281-getter|0|281-preInit
    /**
     * Returns an initiliazed instance of ArtsBooks component.
     * @return the initialized component instance
     */
    public List getArtsBooks() {
        if (ArtsBooks == null) {//GEN-END:|281-getter|0|281-preInit
            // write pre-init user code here
            ArtsBooks = new List("Arts and Books", Choice.IMPLICIT);//GEN-BEGIN:|281-getter|1|281-postInit
            ArtsBooks.addCommand(getBackCommand());
            ArtsBooks.addCommand(getSMStofriend1());
            ArtsBooks.setCommandListener(this);
            ArtsBooks.setFitPolicy(Choice.TEXT_WRAP_DEFAULT);//GEN-END:|281-getter|1|281-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
			ArtsBooks.append("News \n",null);
                        Vector rssItems = parser.parse("http://feeds.nytimes.com/nyt/rss/SundayBookReview");

			for(int i = 0; i < rssItems.size() && i < 5; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i + 1) + " . " +(String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                count = output.length();
                                int z = 0 ;
                                while(count < s.length())
                                {
                                    if(s.charAt(count) == '<')
                                    {
                                        count++;
                                        while(s.charAt(count) != '>')
                                            count++;
                                        count++;
                                    }
                                    else
                                    {
                                        if(output != null )output = output + s.charAt(count);
                                        else output = " " + s.charAt(count);
                                        count++;
                                    }
                                }
                          ArtsBooks.append(output, null);
                         }
                }
		catch(Exception e)
		{
			ArtsBooks.append("Server Load high \n Try after sometime ", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|281-getter|2|
        return ArtsBooks;
    }
    //</editor-fold>//GEN-END:|281-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ArtsBooksAction ">//GEN-BEGIN:|281-action|0|281-preAction
    /**
     * Performs an action assigned to the selected list element in the ArtsBooks component.
     */
    public void ArtsBooksAction() {//GEN-END:|281-action|0|281-preAction
        // enter pre-action user code here
        String __selectedString = getArtsBooks().getString(getArtsBooks().getSelectedIndex());//GEN-LINE:|281-action|1|281-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|281-action|2|
    //</editor-fold>//GEN-END:|281-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|287-getter|0|287-preInit
    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {//GEN-END:|287-getter|0|287-preInit
            // write pre-init user code here
            stringItem = new StringItem("", "Contact :\n\n1 . Ashish Raste \n      @ ashishraste@facebook.com\n           +91 - 9626026709\n2. Venkata Narasimhan, A\n      @ writetovnkt@gmail.com\n          +91 - 9943196275\n\nFeel free to contact for any help , feedback and suggestions.");//GEN-LINE:|287-getter|1|287-postInit
            // write post-init user code here
        }//GEN-BEGIN:|287-getter|2|
        return stringItem;
    }
    //</editor-fold>//GEN-END:|287-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem1 ">//GEN-BEGIN:|289-getter|0|289-preInit
    /**
     * Returns an initiliazed instance of stringItem1 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem1() {
        if (stringItem1 == null) {//GEN-END:|289-getter|0|289-preInit
            // write pre-init user code here
            stringItem1 = new StringItem("", "\n\n1. Click on the item you want.\n2. Select view for the news/ feed you want to read.\n3. Use back button for navigation \n4. Set the user feed links and country information in \" Configure \" option");//GEN-LINE:|289-getter|1|289-postInit
            // write post-init user code here
        }//GEN-BEGIN:|289-getter|2|
        return stringItem1;
    }
    //</editor-fold>//GEN-END:|289-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: choiceGroup ">//GEN-BEGIN:|291-getter|0|291-preInit
    /**
     * Returns an initiliazed instance of choiceGroup component.
     * @return the initialized component instance
     */
    public ChoiceGroup getChoiceGroup() {
        if (choiceGroup == null) {//GEN-END:|291-getter|0|291-preInit
            // write pre-init user code here
            choiceGroup = new ChoiceGroup("Country select :", Choice.EXCLUSIVE);//GEN-BEGIN:|291-getter|1|291-postInit
            choiceGroup.append("Africa", null);
            choiceGroup.append("Asia Pacific", null);
            choiceGroup.append("Europe", null);
            choiceGroup.append("Latin America", null);
            choiceGroup.append("Middle East", null);
            choiceGroup.append("South Asia", null);
            choiceGroup.append("USA and Canada", null);
            choiceGroup.append("England", null);
            choiceGroup.setSelectedFlags(new boolean[] { false, false, false, false, false, false, false, false });//GEN-END:|291-getter|1|291-postInit
            // write post-init user code here
        }//GEN-BEGIN:|291-getter|2|
        return choiceGroup;
    }
    //</editor-fold>//GEN-END:|291-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField ">//GEN-BEGIN:|300-getter|0|300-preInit
    /**
     * Returns an initiliazed instance of textField component.
     * @return the initialized component instance
     */
    public TextField getTextField() {
        if (textField == null) {//GEN-END:|300-getter|0|300-preInit
            // write pre-init user code here
            textField = new TextField("User\'s Feed link 1", null, 50, TextField.URL);//GEN-LINE:|300-getter|1|300-postInit
            // write post-init user code here
        }//GEN-BEGIN:|300-getter|2|
        return textField;
    }
    //</editor-fold>//GEN-END:|300-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField1 ">//GEN-BEGIN:|301-getter|0|301-preInit
    /**
     * Returns an initiliazed instance of textField1 component.
     * @return the initialized component instance
     */
    public TextField getTextField1() {
        if (textField1 == null) {//GEN-END:|301-getter|0|301-preInit
            // write pre-init user code here
            textField1 = new TextField("User\'s Feed link 2", null, 50, TextField.URL);//GEN-LINE:|301-getter|1|301-postInit
            // write post-init user code here
        }//GEN-BEGIN:|301-getter|2|
        return textField1;
    }
    //</editor-fold>//GEN-END:|301-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: spacer ">//GEN-BEGIN:|303-getter|0|303-preInit
    /**
     * Returns an initiliazed instance of spacer component.
     * @return the initialized component instance
     */
    public Spacer getSpacer() {
        if (spacer == null) {//GEN-END:|303-getter|0|303-preInit
            // write pre-init user code here
            spacer = new Spacer(16, 1);//GEN-LINE:|303-getter|1|303-postInit
            // write post-init user code here
        }//GEN-BEGIN:|303-getter|2|
        return spacer;
    }
    //</editor-fold>//GEN-END:|303-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField2 ">//GEN-BEGIN:|304-getter|0|304-preInit
    /**
     * Returns an initiliazed instance of textField2 component.
     * @return the initialized component instance
     */
    public TextField getTextField2() {
        if (textField2 == null) {//GEN-END:|304-getter|0|304-preInit
            // write pre-init user code here
            textField2 = new TextField("Friend\'s Phone ( optional - for sharing news option )", null, 32, TextField.PHONENUMBER);//GEN-LINE:|304-getter|1|304-postInit
            // write post-init user code here
        }//GEN-BEGIN:|304-getter|2|
        return textField2;
    }
    //</editor-fold>//GEN-END:|304-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: User1 ">//GEN-BEGIN:|307-getter|0|307-preInit
    /**
     * Returns an initiliazed instance of User1 component.
     * @return the initialized component instance
     */
    public List getUser1() {
        if (User1 == null) {//GEN-END:|307-getter|0|307-preInit
            // write pre-init user code here
            User1 = new List("User Feed 1", Choice.IMPLICIT);//GEN-BEGIN:|307-getter|1|307-postInit
            User1.addCommand(getBackCommand());
            User1.addCommand(getSMStofriend1());
            User1.setCommandListener(this);//GEN-END:|307-getter|1|307-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
			Vector rssItems = parser.parse(user1);

			for(int i = 0; i < rssItems.size() && i < 10; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i + 1) + " . " +(String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                count = output.length();
                                int z = 0 ;
                                while(z < s.length())
                                {
                                    if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                    {
                                        count++;
                                        z++;
                                        while(s.charAt(z) != '>')
                                        {
                                            count++;
                                            z++;
                                        }
                                        z++;
                                    }
                                    else
                                    {
                                        output = output + s.charAt(z);
                                        count++;
                                        z++;
                                    }
                                }
                                output = output + "\n";
                                User1.append(output, null);
                         }
                }
		catch(Exception e)
		{
			User1.append("user URL error \n Verify it", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|307-getter|2|
        return User1;
    }
    //</editor-fold>//GEN-END:|307-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: User1Action ">//GEN-BEGIN:|307-action|0|307-preAction
    /**
     * Performs an action assigned to the selected list element in the User1 component.
     */
    public void User1Action() {//GEN-END:|307-action|0|307-preAction
        // enter pre-action user code here
        String __selectedString = getUser1().getString(getUser1().getSelectedIndex());//GEN-LINE:|307-action|1|307-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|307-action|2|
    //</editor-fold>//GEN-END:|307-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: User2 ">//GEN-BEGIN:|310-getter|0|310-preInit
    /**
     * Returns an initiliazed instance of User2 component.
     * @return the initialized component instance
     */
    public List getUser2() {
        if (User2 == null) {//GEN-END:|310-getter|0|310-preInit
            // write pre-init user code here
            User2 = new List("User Feed 2", Choice.IMPLICIT);//GEN-BEGIN:|310-getter|1|310-postInit
            User2.addCommand(getBackCommand());
            User2.addCommand(getSMStofriend1());
            User2.setCommandListener(this);//GEN-END:|310-getter|1|310-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
			Vector rssItems = parser.parse(user2);

			for(int i = 0; i < rssItems.size() && i < 10; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i + 1) + " . " +(String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                count = output.length();
                                int z = 0 ;
                                while(z < s.length())
                                {
                                    if(s.charAt(z) == '<' || s.charAt(z) == '\n')
                                    {
                                        count++;
                                        z++;
                                        while(s.charAt(z) != '>')
                                        {
                                            count++;
                                            z++;
                                        }
                                        z++;
                                    }
                                    else
                                    {
                                        output = output + s.charAt(z);
                                        count++;
                                        z++;
                                    }
                                }
                                output = output + "\n";
                                User2.append(output, null);
                         }
                }
		catch(Exception e)
		{
			User2.append("user URL error \n Verify it ", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|310-getter|2|
        return User2;
    }
    //</editor-fold>//GEN-END:|310-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: User2Action ">//GEN-BEGIN:|310-action|0|310-preAction
    /**
     * Performs an action assigned to the selected list element in the User2 component.
     */
    public void User2Action() {//GEN-END:|310-action|0|310-preAction
        // enter pre-action user code here
        String __selectedString = getUser2().getString(getUser2().getSelectedIndex());//GEN-LINE:|310-action|1|310-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|310-action|2|
    //</editor-fold>//GEN-END:|310-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand6 ">//GEN-BEGIN:|328-getter|0|328-preInit
    /**
     * Returns an initiliazed instance of backCommand6 component.
     * @return the initialized component instance
     */
    public Command getBackCommand6() {
        if (backCommand6 == null) {//GEN-END:|328-getter|0|328-preInit
            // write pre-init user code here
            backCommand6 = new Command("Back", Command.BACK, 0);//GEN-LINE:|328-getter|1|328-postInit
            // write post-init user code here
        }//GEN-BEGIN:|328-getter|2|
        return backCommand6;
    }
    //</editor-fold>//GEN-END:|328-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: MotoGP ">//GEN-BEGIN:|319-getter|0|319-preInit
    /**
     * Returns an initiliazed instance of MotoGP component.
     * @return the initialized component instance
     */
    public List getMotoGP() {
        if (MotoGP == null) {//GEN-END:|319-getter|0|319-preInit
            // write pre-init user code here
            MotoGP = new List("MotoGP", Choice.IMPLICIT);//GEN-BEGIN:|319-getter|1|319-postInit
            MotoGP.addCommand(getBackCommand6());
            MotoGP.addCommand(getSMStofriend1());
            MotoGP.setCommandListener(this);//GEN-END:|319-getter|1|319-postInit
            KXmlRssParser parser = new KXmlRssParser();
            try
		{
			MotoGP.append("News \n",null);
                        Vector rssItems = parser.parse("http://www.autosport.com/rss/motogpnews.xml");

			for(int i = 0; i < rssItems.size() && i < 10; i++)
			{
                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                String output = null;
                                int count = 0;
                                output = (i+1) + " : " + (String) (((RssItem)rssItems.elementAt(i)).title) + "\n";
                                count = output.length();
                                int z = 0 ;
                                while(count < s.length())
                                {
                                    if(s.charAt(count) == '<')
                                    {
                                        count++;
                                        while(s.charAt(count) != '>')
                                            count++;
                                        count++;
                                    }
                                    else
                                    {
                                        if(output != null )output = output + s.charAt(count);
                                        else output = " " + s.charAt(count);
                                        count++;
                                    }
                                }
                          MotoGP.append(output, null);
                         }
                }
		catch(Exception e)
		{
			MotoGP.append("Server Load high \n Try after sometime ", null);

			e.printStackTrace();
		}
        }//GEN-BEGIN:|319-getter|2|
        return MotoGP;
    }
    //</editor-fold>//GEN-END:|319-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: MotoGPAction ">//GEN-BEGIN:|319-action|0|319-preAction
    /**
     * Performs an action assigned to the selected list element in the MotoGP component.
     */
    public void MotoGPAction() {//GEN-END:|319-action|0|319-preAction
        // enter pre-action user code here
        String __selectedString = getMotoGP().getString(getMotoGP().getSelectedIndex());//GEN-LINE:|319-action|1|319-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|319-action|2|
    //</editor-fold>//GEN-END:|319-action|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: golfpic ">//GEN-BEGIN:|330-getter|0|330-preInit
    /**
     * Returns an initiliazed instance of golfpic component.
     * @return the initialized component instance
     */
    public Image getGolfpic() {
        if (golfpic == null) {//GEN-END:|330-getter|0|330-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|330-getter|1|330-@java.io.IOException
                golfpic = Image.createImage("/golf.png");
            } catch (java.io.IOException e) {//GEN-END:|330-getter|1|330-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|330-getter|2|330-postInit
            // write post-init user code here
        }//GEN-BEGIN:|330-getter|3|
        return golfpic;
    }
    //</editor-fold>//GEN-END:|330-getter|3|
    //</editor-fold>





    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: moto ">//GEN-BEGIN:|335-getter|0|335-preInit
    /**
     * Returns an initiliazed instance of moto component.
     * @return the initialized component instance
     */
    public Image getMoto() {
        if (moto == null) {//GEN-END:|335-getter|0|335-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|335-getter|1|335-@java.io.IOException
                moto = Image.createImage("/moto.png");
            } catch (java.io.IOException e) {//GEN-END:|335-getter|1|335-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|335-getter|2|335-postInit
            // write post-init user code here
        }//GEN-BEGIN:|335-getter|3|
        return moto;
    }
    //</editor-fold>//GEN-END:|335-getter|3|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: user ">//GEN-BEGIN:|337-getter|0|337-preInit
    /**
     * Returns an initiliazed instance of user component.
     * @return the initialized component instance
     */
    public Image getUser() {
        if (user == null) {//GEN-END:|337-getter|0|337-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|337-getter|1|337-@java.io.IOException
                user = Image.createImage("/userfeed.png");
            } catch (java.io.IOException e) {//GEN-END:|337-getter|1|337-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|337-getter|2|337-postInit
            // write post-init user code here
        }//GEN-BEGIN:|337-getter|3|
        return user;
    }
    //</editor-fold>//GEN-END:|337-getter|3|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: SMStofriend ">//GEN-BEGIN:|339-getter|0|339-preInit
    /**
     * Returns an initiliazed instance of SMStofriend component.
     * @return the initialized component instance
     */
    public Command getSMStofriend() {
        if (SMStofriend == null) {//GEN-END:|339-getter|0|339-preInit
            // write pre-init user code here
            SMStofriend = new Command("Ok", Command.OK, 0);//GEN-LINE:|339-getter|1|339-postInit
            // write post-init user code here
        }//GEN-BEGIN:|339-getter|2|
        return SMStofriend;
    }
    //</editor-fold>//GEN-END:|339-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: SMStofriend1 ">//GEN-BEGIN:|341-getter|0|341-preInit
    /**
     * Returns an initiliazed instance of SMStofriend1 component.
     * @return the initialized component instance
     */
    public Command getSMStofriend1() {
        if (SMStofriend1 == null) {//GEN-END:|341-getter|0|341-preInit
            // write pre-init user code here
            SMStofriend1 = new Command("Send as SMS", Command.OK, 0);//GEN-LINE:|341-getter|1|341-postInit
            // write post-init user code here
        }//GEN-BEGIN:|341-getter|2|
        return SMStofriend1;
    }
    //</editor-fold>//GEN-END:|341-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tech ">//GEN-BEGIN:|363-getter|0|363-preInit
    /**
     * Returns an initiliazed instance of tech component.
     * @return the initialized component instance
     */
    public Image getTech() {
        if (tech == null) {//GEN-END:|363-getter|0|363-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|363-getter|1|363-@java.io.IOException
                tech = Image.createImage("/tech.png");
            } catch (java.io.IOException e) {//GEN-END:|363-getter|1|363-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|363-getter|2|363-postInit
            // write post-init user code here
        }//GEN-BEGIN:|363-getter|3|
        return tech;
    }
    //</editor-fold>//GEN-END:|363-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: gadgets1 ">//GEN-BEGIN:|364-getter|0|364-preInit
    /**
     * Returns an initiliazed instance of gadgets1 component.
     * @return the initialized component instance
     */
    public Image getGadgets1() {
        if (gadgets1 == null) {//GEN-END:|364-getter|0|364-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|364-getter|1|364-@java.io.IOException
                gadgets1 = Image.createImage("/gadgets.png");
            } catch (java.io.IOException e) {//GEN-END:|364-getter|1|364-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|364-getter|2|364-postInit
            // write post-init user code here
        }//GEN-BEGIN:|364-getter|3|
        return gadgets1;
    }
    //</editor-fold>//GEN-END:|364-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: rss ">//GEN-BEGIN:|365-getter|0|365-preInit
    /**
     * Returns an initiliazed instance of rss component.
     * @return the initialized component instance
     */
    public Image getRss() {
        if (rss == null) {//GEN-END:|365-getter|0|365-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|365-getter|1|365-@java.io.IOException
                rss = Image.createImage("/rss.jpg");
            } catch (java.io.IOException e) {//GEN-END:|365-getter|1|365-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|365-getter|2|365-postInit
            // write post-init user code here
        }//GEN-BEGIN:|365-getter|3|
        return rss;
    }
    //</editor-fold>//GEN-END:|365-getter|3|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: feedspic1 ">//GEN-BEGIN:|367-getter|0|367-preInit
    /**
     * Returns an initiliazed instance of feedspic1 component.
     * @return the initialized component instance
     */
    public Image getFeedspic1() {
        if (feedspic1 == null) {//GEN-END:|367-getter|0|367-preInit
            // write pre-init user code here
            try {//GEN-BEGIN:|367-getter|1|367-@java.io.IOException
                feedspic1 = Image.createImage("/rss.jpg");
            } catch (java.io.IOException e) {//GEN-END:|367-getter|1|367-@java.io.IOException
                e.printStackTrace();
            }//GEN-LINE:|367-getter|2|367-postInit
            // write post-init user code here
        }//GEN-BEGIN:|367-getter|3|
        return feedspic1;
    }
    //</editor-fold>//GEN-END:|367-getter|3|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: About ">//GEN-BEGIN:|371-getter|0|371-preInit
    /**
     * Returns an initiliazed instance of About component.
     * @return the initialized component instance
     */
    public Form getAbout() {
        if (About == null) {//GEN-END:|371-getter|0|371-preInit
            // write pre-init user code here
            About = new Form("About", new Item[] { getTextField3() });//GEN-LINE:|371-getter|1|371-postInit
            // write post-init user code here
        }//GEN-BEGIN:|371-getter|2|
        return About;
    }
    //</editor-fold>//GEN-END:|371-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textField3 ">//GEN-BEGIN:|373-getter|0|373-preInit
    /**
     * Returns an initiliazed instance of textField3 component.
     * @return the initialized component instance
     */
    public TextField getTextField3() {
        if (textField3 == null) {//GEN-END:|373-getter|0|373-preInit
            // write pre-init user code here
            textField3 = new TextField("About", "Developer name: Vendor b) Application name: Feedli c) The version number: 1.0", 32, TextField.ANY);//GEN-LINE:|373-getter|1|373-postInit
            // write post-init user code here
        }//GEN-BEGIN:|373-getter|2|
        return textField3;
    }
    //</editor-fold>//GEN-END:|373-getter|2|

    private void sendMsg(String rcvr, String port, String msgText)
    {
        String address = new String("sms://" + rcvr + ":" + port);
        try {
            /** Open the message connection. */
            conn2 = (MessageConnection) Connector.open("sms://:"+ 1234);
            conn2.setMessageListener(this);
            TextMessage txtmessage = (TextMessage) conn2.newMessage(MessageConnection.TEXT_MESSAGE);
            txtmessage.setAddress(address);
            txtmessage.setPayloadText(msgText);
            conn2.send(txtmessage);
            conn2.close();
            System.out.println("Sent" + address + "   " + "sms://:"+ port);
            } catch (Throwable t) {
                System.out.println(t);
        }
     }





    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    public void notifyIncomingMessage(MessageConnection mc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
