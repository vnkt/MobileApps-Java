/* author Venkata Narasimhan, A
 * (c) all rights reserved */

package hello;

import javax.microedition.midlet.*;
import com.sun.lwuit.*;
import com.sun.lwuit.events.*;
import javax.wireless.messaging.*;
import javax.microedition.rms.*;
import com.sun.lwuit.list.ListCellRenderer;
import java.io.*;
import com.sun.lwuit.layouts.*;
import javax.microedition.io.Connector;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;
import com.sun.lwuit.list.DefaultListModel;
import java.lang.Object.*;
import com.sun.lwuit.List;
import com.sun.lwuit.geom.Dimension;
import com.sun.lwuit.Display;
import com.sun.lwuit.TextField;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.animations.Transition;


public class Splice extends MIDlet implements ActionListener, MessageListener   {

    private Form ChatForm;
    private TextArea Chat;
    private TextField ChatText;
    private Command ChatExitCommand, ChatSendCommand;
    private List Clist;
    DefaultListModel myListModel;

    private Form Nokia;
    private Button Launch, Help, About, Exit;

    private Form compose;
    private Command CaddCommand, CcancelCommand;
    private TextField newName;
    private TextArea newNumber;

    private Form ConnectForm;
    private TextArea[] mNumberEntry = null, mName = null;

    private List mList;
    Form mListForm;
    private Command mNextCommand, mAdd,  mDelete;
    private Command mExitCommand  = new Command("Back ");
    private Command mSend  = new Command("Connect ");
    private Button mAddThis = null;

    String temp;
    
    private String mPort = "1010";
    String[] dest;
    String[] nick;
    
    int count;
    String msgReceived = null;
    int num = 1;
    
    String[] temp1,temp2;
    Image[] im;

    private RecordStore recordstore = null;
    private RecordEnumeration recordEnumeration = null;
    private Comparator comparator = null;
    private boolean mEndNow ;
    private MessageConnection conn = null;

    String[] stringElements, phone;
    Transition in, out;

    private Form Welcome;
    private Command wOk  = new Command("Okay");

           
    public Splice()
    {
       ChatExitCommand  = new Command("Close");
       ChatSendCommand = new Command("Send ");
       
       CaddCommand = new Command("Save");
       CcancelCommand =new Command("Cancel");

       mNextCommand = new Command("Proceed");
       mAdd = new Command("Add contact");
       mDelete = new Command("Delete contact");

       dest = new String[7];
       nick = new String[7];

       mNumberEntry = new TextArea[5];
       mName = new TextArea[5];


        num = getNum();
        if (num == 0)
            num = 1;
        count = 0;
        readRecord();

    }

    public void startApp() {

            Display.init(this);
            try
            {

                Resources r1 = Resources.open("/theme.res");
                UIManager.getInstance().setThemeProps(r1.getTheme(r1.getThemeResourceNames()[0]));
            } 
            catch (Exception ex)
            {
                ex.printStackTrace();
                Dialog.show("Exception", ex.getMessage(), "OK", null);
                Dialog d = new Dialog("Exception");
                d.setDialogType(Dialog.TYPE_ALARM );
                d.show();
            }

            Form f = new Form("");
            Image image;
            try {
                image = Image.createImage("/temp.png");
                Label pictureLabel = new Label(image);
                f.addComponent(pictureLabel);
                f.show();
                }
            catch (IOException ex) {
            ex.printStackTrace();
            }
            
            try
            {
            Thread.sleep(1000);
            }
             catch (InterruptedException ex) {
            ex.printStackTrace();
            }
                  
            Nokia = new Form("Welcome to Splice");
            Launch = new Button(" Start Splicing ");
            Launch.setAlignment(Button.CENTER);
            Help = new Button(" Help ");
            Help.setAlignment(Button.CENTER);
            About = new Button(" About ");
            About.setAlignment(Button.CENTER);
            Exit = new Button(" Exit ");
            Exit.setAlignment(Button.CENTER);
            
            Launch.addActionListener(this);
            Help.addActionListener(this);
            About.addActionListener(this);
            Exit.addActionListener(this);

            Nokia.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            Nokia.addComponent(Launch);
            Nokia.addComponent(Help);
            Nokia.addComponent(About);
            Nokia.addComponent(Exit);
            Nokia.show();
            
    }


    public void pauseApp() {}


    public void destroyApp(boolean unconditional) {}


    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == Exit)
        {
            notifyDestroyed();
        }

        if(ae.getSource() == Help)
        {
            Welcome = new Form("Welcome : Help and Contact");
            Welcome.addComponent(new Label("Contact : avn1990@gmail.com"));
            Welcome.addComponent(new Label("Contact : +91-9943196275"));
            Welcome.addComponent(new Label(" "));
            TextArea ta = new TextArea(10,50);
            ta.setEditable(false);
            Welcome.addComponent(new Label("Help :"));
            ta.setText("1.Make sure the persons who you want to chat with also have the applciation installed in their mobile.\n\n3.First time the phone book will be empty. You have to add the details of all the contacts whom you want to chat with before proceeding.\n\n3.The entry is one time. Once entered it stays for ever.\n\n4.To enter a new number Click on menu - > add contact.\n\n5.Just type in the name(preferably small) or else use the t9 option.\n\n6.After entering the name press down button and the click(center) on the number button.\n\n7.You can type in the numebr as such or use menu -> select from contact to use existing number.\n\n8.Remove the country prefix if present. Dont type in the prefix\n\n9.Hit on save and the contact is saved!\n\n10. Repeat 7 to 11 to add new contacts.\n\n12. To delete contact select it and menu -> delete contact. \n\n13.Now click on each person in the current group and then hit add this number button.\n\n14.Even if high lighted the contact is added only when u click on the item in the list (middle click once )and then hit add this number.\n\n15.Once after selecting enough contacts hit proceed.\n\n16.Details of the contacts selected will be there.\n\n17.Confirm if oki or else go back to change.\n\n19.Start chatting :) :) \n\n you are connected now.\n\n PLS keep hitting okay if u are prompted for sending messages or recieving messages. ");
            Welcome.addComponent(ta);

            Welcome.addCommand(wOk);
            Welcome.setCommandListener(this);
            Welcome.show();
        }

        if(ae.getSource() == About)
        {
            Welcome = new Form("About");
            TextArea ta = new TextArea(10,50);
            ta.setEditable(false);
            Welcome.addComponent(new Label("About"));
            ta.setText("Developer name: Vendor \nApplication name: Splice \nThe version number: 1.0");
            Welcome.addComponent(ta);

            Welcome.addCommand(wOk);
            Welcome.setCommandListener(this);
            Welcome.show();
        }
        
        if(ae.getSource() == Launch)
        {
            Display.init(this);
            readRecord();

            if(num == 1)
            {
                Dialog.show("Help", " Since there are no numbers in the list " +
                        "as of now click on the add contact and create a new contact ", "OK", null);
                Dialog.show("Help", " After adding enough contacts select all you want and click on Procceed ", "OK", null);
            }
            myListModel = new DefaultListModel(stringElements);
            mList = new List(myListModel);
            mList.setListCellRenderer(new AlternateImageRenderer());
            mList.setFixedSelection(List.FIXED_NONE);
            mList.getStyle().setBgTransparency(0);
            mList.setSize(new Dimension(Display.getInstance().getDisplayWidth(),Display.getInstance().getDisplayHeight()));
            mListForm = new Form("Phone Book");
            Label head = new Label("Select a Name from the List / add");
            mAddThis = new Button(" Add this number ");
            mAddThis.setAlignment(Button.CENTER);
            mListForm.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

            out = CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, false, 500);
            in = CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 500);
            mListForm.setTransitionOutAnimator(out);
            mListForm.setTransitionInAnimator(in);

            mListForm.addComponent(head);
            mListForm.addComponent(mList);
            mListForm.addComponent(mAddThis);
            mListForm.addCommand(mNextCommand);
            mListForm.addCommand(mDelete);
            mListForm.addCommand(mAdd);
            mListForm.setCommandListener(this);
            mAddThis.addActionListener( new ActionListener()
            {
               public void actionPerformed(ActionEvent ae)
                {
                   if(count < 7)
                   {
                       int a = mList.getSelectedIndex();
                       for(int d = 0 ; d < count ; d++)
                       {
                             if(phone[a].equals(dest[d]))
                               return;
                       }
                       nick[count] = stringElements[a];
                       dest[count] = phone[a];
                       count++;
                       Dialog.show("Help", stringElements[a]+" Added", "OK", null);
                    }
                   else
                   {

                   }
                }
             });
             mListForm.show();
        }


        if(ae.getSource() == wOk)
        {
            Display.init(this);
            readRecord();

            if(num == 1)
            {
                Dialog.show("Help", " Since there are no numbers in the list " +
                        "as of now click on the add contact and create a new contact ", "OK", null);
                Dialog.show("Help", " After adding enough contacts select all you want and click on Procceed ", "OK", null);
            }
            myListModel = new DefaultListModel(stringElements);
            mList = new List(myListModel);
            mList.setListCellRenderer(new AlternateImageRenderer());
            mList.setFixedSelection(List.FIXED_NONE);
            mList.getStyle().setBgTransparency(0);
            mList.setSize(new Dimension(Display.getInstance().getDisplayWidth(),Display.getInstance().getDisplayHeight()));
            mListForm = new Form("Phone Book");
            Label head = new Label("Select a Name from the List / add");
            mAddThis = new Button(" Add this number ");
            mAddThis.setAlignment(Button.CENTER);
            mListForm.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

            out = CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, false, 500);
            in = CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 500);
            mListForm.setTransitionOutAnimator(out);
            mListForm.setTransitionInAnimator(in);

            mListForm.addComponent(head);
            mListForm.addComponent(mList);
            mListForm.addComponent(mAddThis);
            mListForm.addCommand(mNextCommand);
            mListForm.addCommand(mDelete);
            mListForm.addCommand(mAdd);
            mListForm.setCommandListener(this);
            mAddThis.addActionListener( new ActionListener()
            {
               public void actionPerformed(ActionEvent ae)
                {
                   if(count < 7)
                   {
                       int a = mList.getSelectedIndex();
                       for(int d = 0 ; d < count ; d++)
                       {
                             if(phone[a].equals(dest[d]))
                               return;
                       }
                       nick[count] = stringElements[a];
                       dest[count] = phone[a];
                       count++;
                       Dialog.show("Help", stringElements[a]+" Added", "OK", null);
                    }
                   else
                   {

                   }
                }
             });
             mListForm.show();
        }

        if(ae.getCommand() == mNextCommand)
        {

            if(num == 1)
            {
                Dialog.show("Help", " Confirm your selection \n\n Can go back and edit of course ", "OK", null);
            }

            ConnectForm = new Form("Connection ");
            Label l = new Label("Connect ");
            ConnectForm.addComponent(l);
            Label l1 = new Label("Name");
            Label l2 = new Label("Number");
                     
            GridLayout exampleLayout = new GridLayout(6,3);
            ConnectForm.setLayout(exampleLayout);
            ConnectForm.addComponent(l1);
            ConnectForm.addComponent(l2);
            
            out = CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, false, 500);
            ConnectForm.setTransitionOutAnimator(out);
            
            for(int i=0;i<count;i++)
            {
                mNumberEntry[i] = new TextArea("",1,12, TextArea.PHONENUMBER);
                mName[i] = new TextArea("",1,5, TextArea.ANY);
                mNumberEntry[i].setText(dest[i]);
                mName[i].setText(nick[i]);
                mName[i].setEditable(false);
                mNumberEntry[i].setEditable(false);
                ConnectForm.addComponent(new Label(""+(i+1)));
                ConnectForm.addComponent(mName[i]);
                ConnectForm.addComponent(mNumberEntry[i]);
            }
            
            ConnectForm.addCommand(mSend);
            ConnectForm.addCommand(mExitCommand);
            ConnectForm.setCommandListener(this);
            ConnectForm.show();
            
        }


        if(ae.getCommand() == mAdd)
        {
            if(num == 1)
            {
                Dialog.show("Help", "Enter the details \n\nType a short name -  nick name preferrably \n\nType in the number or select from your phone ", "OK", null);
            }
             
            compose = new Form("Add contact");
            Label nName = new Label("Name");
            newName = new TextField("",24);
            Label nNumber = new Label("Number");
            newNumber = new TextArea("",1,12,TextArea.PHONENUMBER);
            CaddCommand = new Command("Save");
            CcancelCommand =new Command("Cancel");
            compose.addComponent(nName);
            compose.addComponent(newName);
            compose.addComponent(nNumber);
            compose.addComponent(newNumber);
            compose.addCommand(CaddCommand);
            compose.addCommand(CcancelCommand);
            compose.setCommandListener(this);
            compose.show();
        }


        if(ae.getCommand() == mDelete)
        {
            try
            {
                int me = 0;
                me = mList.getSelectedIndex();

                comparator = new Comparator();
                recordstore = RecordStore.openRecordStore("myRecordStore", true );
                recordEnumeration = recordstore.enumerateRecords(null, comparator, false);

                int z = 1;
                byte[] byteInputData = new byte[50];
                ByteArrayInputStream inputStream = new ByteArrayInputStream(byteInputData);
                DataInputStream inputDataStream = new DataInputStream(inputStream);

                comparator = new Comparator();
                recordstore = RecordStore.openRecordStore("myRecordStore", true );
                recordEnumeration = recordstore.enumerateRecords(null, comparator, false);

                while (recordEnumeration.hasNextElement())
                {
                    recordstore.getRecord( recordEnumeration.nextRecordId(),byteInputData, 0);
                    String del1 = inputDataStream.readUTF();
                    String del2 = inputDataStream.readUTF();
                    if (del1.equals(stringElements[me]) && del2.equals(phone[me]))
                    {
                        recordstore.deleteRecord(inputDataStream.readInt());
                         Dialog.show("Help", stringElements[me] + " Deleted", "OK", null);
                    }
                }
                  recordstore.closeRecordStore();
            }
                catch(Exception e)
            {
            }

            readRecord();
            myListModel = new DefaultListModel(stringElements);
            mList = new List(myListModel);
            mList.setListCellRenderer(new AlternateImageRenderer());
            mListForm = new Form("Phone Book");
            mList.setSize(new Dimension(Display.getInstance().getDisplayWidth(),Display.getInstance().getDisplayHeight()));
            Label head = new Label("Select a Name from the List / add");
            mAddThis = new Button(" Add this number ");
            mAddThis.setAlignment(Button.CENTER);

            out = CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, false, 500);
            in = CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 500);

            mListForm.setTransitionOutAnimator(out);
            mListForm.setTransitionInAnimator(in);

            mListForm.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            mList.setFixedSelection(List.FIXED_CENTER);
            mList.getStyle().setBgTransparency(0);
            mListForm.addComponent(head);
            mListForm.addComponent(mList);
            mListForm.addComponent(mAddThis);
            mListForm.addCommand(mNextCommand);
            mListForm.addCommand(mDelete);
            mListForm.addCommand(mAdd);
            mListForm.setCommandListener(this);
            mAddThis.addActionListener( new ActionListener()
            {
               public void actionPerformed(ActionEvent ae)
                {
                   if(count < 7)
                   {
                       int a = mList.getSelectedIndex();
                       for(int d = 0 ; d < count ; d++)
                       {
                            if(phone[a].equals(dest[d]))
                                return;
                       }
                       nick[count] = stringElements[a];
                       dest[count] = phone[a];
                       count++;
                       Dialog.show("Help", stringElements[a]+" Added", "OK", null);
                    }
                   else
                   {

                   }
                }
             });
            mListForm.show();
        }

        if(ae.getCommand() == mExitCommand)
        {
            readRecord();
            dest = new String[7];
            nick = new String[7];
            count = 0;
            myListModel = new DefaultListModel(stringElements);
            mList = new List(myListModel);
            mList.setListCellRenderer(new AlternateImageRenderer());
            mListForm = new Form("Phone Book");
            mList.setSize(new Dimension(Display.getInstance().getDisplayWidth(),Display.getInstance().getDisplayHeight()));
            Label head = new Label("Select a Name from the List / add");
            mAddThis = new Button(" Add this number ");
            mAddThis.setAlignment(Button.CENTER);
            mListForm.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            mList.setFixedSelection(List.FIXED_NONE_CYCLIC);
            mList.getStyle().setBgTransparency(0);
            mListForm.addComponent(head);
            mListForm.addComponent(mList);
            mListForm.addComponent(mAddThis);
            mListForm.addCommand(mNextCommand);
            mListForm.addCommand(mDelete);
            mListForm.addCommand(mAdd);
            mListForm.setCommandListener(this);
            mAddThis.addActionListener( new ActionListener()
            {
               public void actionPerformed(ActionEvent ae)
                {
                   if(count < 7)
                   {
                       int a = mList.getSelectedIndex();
                       for(int d = 0 ; d < count ; d++)
                       {
                            if(phone[a].equals(dest[d]))
                                return;
                       }
                       nick[count] = stringElements[a];
                       dest[count] = phone[a];
                       count++;
                       Dialog.show("Help", stringElements[a]+" Added", "OK", null);
                    }
                   else
                   {

                   }
                }
             });
             mListForm.show();
        }

        
        if(ae.getCommand() == mSend)
        {
            conn = null;
            mEndNow = false;
            try
            {
                conn = (MessageConnection) Connector.open("sms://:"+ mPort );
                conn.setMessageListener(this);
            }
            catch (IOException e)
            {
            }
            for(int f = 0 ; f < count ; f++ )
            {
                try{
                    sendMsg(dest[f], mPort, "Please open the Splice application -- i want to chat ");
                    sendMsg(dest[f], "0", "Please open the Splice application -- i want to chat ");
                    }
                catch(Exception e)
                {
                 }
            }
            

            if(num == 1)
            {
                Dialog.show("Happy to help", "Finally over ! \n\n Type in the text and click send ! \n\n Look out for the friend online messages... \n\n Happy chatting ", "OK", null);
            }
            
            ChatForm = new Form("Chat Screen");
            Label cT = new Label("Enter the chat text here ");
            ChatText = new TextField("",10 );
            myListModel = new DefaultListModel();
            Clist = new List(myListModel);
            Clist.setListCellRenderer(new AlternateImageRenderer());
            Clist.setWidth(20);
            Clist.setFixedSelection(List.FIXED_NONE_CYCLIC);
            Clist.getStyle().setBgTransparency(0);

            out = CommonTransitions.createFade(500);
            ChatForm.setTransitionOutAnimator(out);
                        
            Label cH = new Label("Chat History");
            Chat = new TextArea("", 5 , 10);
            Chat.setEditable(false);
            ChatForm.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            ChatForm.addComponent(cT);
            ChatForm.addComponent(ChatText);
            ChatForm.setScrollable(true);
            ChatForm.addComponent(cH);
            ChatForm.addComponent(Clist);
            ChatForm.addComponent(Chat);
            ChatForm.addCommand(ChatSendCommand);
            ChatForm.addCommand(ChatExitCommand);
            Display.init(this);
            ChatForm.setCommandListener(this);
            ChatForm.show();
        }

        
        if(ae.getCommand() == CaddCommand)
        {
            ByteArrayOutputStream outputStream =new ByteArrayOutputStream();
            DataOutputStream outputDataStream = new DataOutputStream(outputStream);
            byte[] outputRecord;
            if(!(newName.getText().equals("")))
            {
                try
                {
                    outputDataStream.writeUTF(newName.getText());
                    outputDataStream.writeUTF(newNumber.getText());
                    outputDataStream.writeInt(num);
                    outputDataStream.flush();
                    outputRecord = outputStream.toByteArray();
                    recordstore = RecordStore.openRecordStore("myRecordStore", true );
                    recordEnumeration = recordstore.enumerateRecords(null, comparator, false);
                    recordstore.addRecord(outputRecord, 0,outputRecord.length);
                    outputStream.reset();
                    outputDataStream.close();
                    recordstore.closeRecordStore();
                    num++;

                    outputStream =new ByteArrayOutputStream();
                    outputDataStream = new DataOutputStream(outputStream);
                    outputDataStream.writeInt(num);
                    outputDataStream.flush();
                    outputRecord = outputStream.toByteArray();
                    recordstore = RecordStore.openRecordStore("indexStore", true );
                    recordEnumeration = recordstore.enumerateRecords(null, comparator, false);
                    recordstore.addRecord(outputRecord, 0,outputRecord.length);
                    outputStream.reset();
                    outputDataStream.close();
                    recordstore.closeRecordStore();
                    newName.setText("");
                    newNumber.setText("");
                }
                catch(Exception e)
                {
                }
            }
            readRecord();
            myListModel = new DefaultListModel(stringElements);
            mList = new List(myListModel);
            mList.setListCellRenderer(new AlternateImageRenderer());
            mListForm = new Form("Phone Book");
            mList.setSize(new Dimension(Display.getInstance().getDisplayWidth(),Display.getInstance().getDisplayHeight()));
            Label head = new Label("Select a Name from the List / add");
            mAddThis = new Button(" Add this number ");
            mAddThis.setAlignment(Button.CENTER);

            out = CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, false, 500);
            in = CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 500);
            mListForm.setTransitionOutAnimator(out);
            mListForm.setTransitionInAnimator(in);

            mListForm.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            mList.setFixedSelection(List.FIXED_NONE_CYCLIC);
            mList.getStyle().setBgTransparency(0);
            mListForm.addComponent(head);
            mListForm.addComponent(mList);
            mListForm.addComponent(mAddThis);
            mListForm.addCommand(mNextCommand);
            mListForm.addCommand(mDelete);
            mListForm.addCommand(mAdd);
           

            mListForm.setCommandListener(this);
            mAddThis.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                   if(count < 7)
                   {
                       int a = mList.getSelectedIndex();
                       for(int d = 0 ; d < count ; d++)
                       {
                            if(phone[a].equals(dest[d]))
                                return;
                       }
                       nick[count] = stringElements[a];
                       dest[count] = phone[a];
                       count++;
                       Dialog.show("Help", stringElements[a]+" Added", "OK", null);
                    }
                   else
                   {

                   }
                }
             });
           mListForm.show();
       }    

        if(ae.getCommand() == CcancelCommand)
        {
            readRecord();
            myListModel = new DefaultListModel(stringElements);
            mList = new List(myListModel);
            mList.setListCellRenderer(new AlternateImageRenderer());
            mListForm = new Form("Phone Book");
            mList.setSize(new Dimension(Display.getInstance().getDisplayWidth(),Display.getInstance().getDisplayHeight()));
            Label head = new Label("Select a Name from the List / add");
            mAddThis = new Button(" Add this number ");
            mAddThis.setAlignment(Button.CENTER);
            mListForm.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            mList.setFixedSelection(List.FIXED_NONE_CYCLIC);
            mList.getStyle().setBgTransparency(0);
            mListForm.addComponent(head);
            mListForm.addComponent(mList);
            mListForm.addComponent(mAddThis);
            mListForm.addCommand(mNextCommand);
            mListForm.addCommand(mDelete);
            mListForm.addCommand(mAdd);
           
            mListForm.setCommandListener(this);
            mAddThis.addActionListener( new ActionListener()
            {
               public void actionPerformed(ActionEvent ae)
                {
                   if(count < 7)
                   {
                       int a = mList.getSelectedIndex();
                       for(int d = 0 ; d < count ; d++)
                       {
                            if(phone[a].equals(dest[d]))
                               return;
                       }
                       nick[count] = stringElements[a];
                       dest[count] = phone[a];
                       count++;
                       Dialog.show("Help", stringElements[a]+" Added", "OK", null);
                    }
                   else
                   {

                   }
                }
             });
            mListForm.show();
        }

        
        if(ae.getCommand() == ChatExitCommand)
        {
            readRecord();
            dest = new String[7];
            nick = new String[7];
            count = 0;
            myListModel = new DefaultListModel(stringElements);
            mList = new List(myListModel);
            mList.setListCellRenderer(new AlternateImageRenderer());
            mListForm = new Form("Phone Book");
            mList.setSize(new Dimension(Display.getInstance().getDisplayWidth(),Display.getInstance().getDisplayHeight()));
            Label head = new Label("Select a Name from the List / add");
            mAddThis = new Button(" Add this number ");
            mAddThis.setAlignment(Button.CENTER);
            mListForm.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            mList.setFixedSelection(List.FIXED_NONE_CYCLIC);
            mList.getStyle().setBgTransparency(0);
            mListForm.addComponent(head);
            mListForm.addComponent(mList);
            mListForm.addComponent(mAddThis);
            mListForm.addCommand(mNextCommand);
            mListForm.addCommand(mDelete);
            mListForm.addCommand(mAdd);
            mListForm.setCommandListener(this);
            mAddThis.addActionListener( new ActionListener()
            {
               public void actionPerformed(ActionEvent ae)
                {
                   if(count < 7)
                   {
                       int a = mList.getSelectedIndex();
                       for(int d = 0 ; d < count ; d++)
                       {
                            if(phone[a].equals(dest[d]))
                               return;
                       }
                       nick[count] = stringElements[a];
                       dest[count] = phone[a];
                       count++;
                       Dialog.show("Help", stringElements[a]+" Added", "OK", null);
                    }
                   else
                   {

                   }
                }
             });
             mListForm.show();
        }



        if(ae.getCommand() == ChatSendCommand )
        {
            String str = Chat.getText();
            String prev = ChatText.getText();
            int x = 0;
            for(int i = 0 ; i < count ; i++ )
                 {
                      sendMsg(dest[i], mPort, ChatText.getText());
                 }
           
           myListModel.removeAll();
           Clist = new List(myListModel);
           Clist.setListCellRenderer(new AlternateImageRenderer());
           Clist.setFixedSelection(List.FIXED_NONE_CYCLIC);
           Clist.getStyle().setBgTransparency(0);
           ChatForm = new Form("Chat Screen");
           Label cT = new Label("Enter the chat text here ");
           ChatText = new TextField("", 10 );
           Label cH = new Label("Chat History");
           Chat = new TextArea("", 10 , 10);
           Chat.setEditable(false);
           ChatForm.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
           ChatForm.addComponent(cT);
           ChatForm.setScrollable(true);
           Clist.setWidth(20);
           ChatForm.addComponent(ChatText);
           ChatForm.addComponent(cH);
           ChatForm.addComponent(Clist);
           ChatForm.addComponent(Chat);
           ChatForm.addCommand(ChatSendCommand);
           ChatForm.addCommand(ChatExitCommand);
           ChatForm.setCommandListener(this);
           if(prev.length() > 25)
           {
                while(prev.length() > 25)
                {
                    String msgReceived2 = prev.substring(1,25);
                    if(x ==0 )
                    {
                        Clist.addItem(new Label("Me " + " : "+ msgReceived2));
                        Chat.setText("Me" + " : " + msgReceived2 + "\n" + str);
                    }
                    else
                    {
                        Clist.addItem("     " + msgReceived2);
                        Chat.setText("     " + msgReceived2 + "\n" + str);
                    }

                    ChatForm.show();
                    prev = prev.substring(25);
                    x++;
                }
               
            }
            else
                {
                    Clist.addItem("Me" + " : " + prev);
                    ChatForm.show();
                    Chat.setText("Me" + " : " + prev + "\n" + str);
                }
         }

    }
    
    private void sendMsg(String rcvr, String port, String msgText)
    {
        String address = new String("sms://" + rcvr + ":" + port);
        try {
            /** Open the message connection. */
            TextMessage txtmessage = (TextMessage) conn.newMessage(MessageConnection.TEXT_MESSAGE);
            txtmessage.setAddress(address);
            txtmessage.setPayloadText(msgText);
            conn.send(txtmessage);
            } catch (Throwable t) {
        }
     }

    public void notifyIncomingMessage(MessageConnection conn)
    {
        Dialog.show("Happy to help","Got", "OK", null);
        try
        {
            Message msg = null;
            try
            {
                msg = conn.receive();
            }
            catch (Exception e)
            {
                System.out.println("1");
            }
        if (msg instanceof TextMessage)
        {
            /* author Venkata Narasimhan, A
            * (c) all rights reserved */
            TextMessage tmsg = (TextMessage)msg;
            msgReceived = tmsg.getPayloadText();
            String sender = tmsg.getAddress();
            String name = "Incoming 1";
            String name2 = "Incoming 2";

            Display.init(this);
            String str = Chat.getText();
            myListModel.removeAll();
            Clist = new List(myListModel);
            Clist.setListCellRenderer(new AlternateImageRenderer());
            Clist.setFixedSelection(List.FIXED_NONE_CYCLIC);
            Clist.getStyle().setBgTransparency(0);
            ChatForm = new Form("Chat Screen");
            Label cT = new Label("Enter the chat text here ");
            ChatText = new TextField("", 10 );
            Label cH = new Label("Chat History");
            Chat = new TextArea("", 10 , 10);
            Chat.setEditable(false);
            ChatForm.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            ChatForm.addComponent(cT);
            ChatForm.addComponent(ChatText);
            ChatForm.setScrollable(true);
            Clist.setWidth(20);
            ChatForm.addComponent(cH);
            ChatForm.addComponent(Clist);
            ChatForm.addComponent(Chat);
            ChatForm.addCommand(ChatSendCommand);
            ChatForm.addCommand(ChatExitCommand);
            ChatForm.setCommandListener(this);
                    
            for(int i =0 ; i< phone.length ;i++)
            {
              try
              {
                if(sender.substring(7,15).equals(phone[i]) || sender.substring(7,19).equals(phone[i]) )
                {
                    name = stringElements[i];
                    name2 = stringElements[i];
               }
              }
              catch(Exception e)
              {
                  System.out.println("2");
              }
            }

            if(msgReceived.equals("Please open the application -- i want to chat "))
            {
               Chat.setText( name2 + " is Online " + "\n" + str);
               ChatForm.show();
            }
            else
            {
                try
                {
                    int x = 0;
                    
                    if(msgReceived.length() > 25)
                    {
                        while(msgReceived.length() > 25)
                        {

                            String msgReceived2 = msgReceived.substring(1,25);
                            if(x ==0 )
                            {
                                Clist.addItem(new Label(name + " : "+ msgReceived2));
                                Chat.setText(name2 + " : " + msgReceived2 + "\n" + str);
                            }
                            else
                            {
                                Clist.addItem("     " + msgReceived2);
                                Chat.setText("     " + msgReceived2 + "\n" + str);
                            }
                        ChatForm.show();
                        msgReceived = msgReceived.substring(25);
                        x++;
                        }
                    }
                    else
                    {
                        Clist.addItem(name + " : " + msgReceived);
                        ChatForm.show();
                        Chat.setText(name + " : " + msgReceived + "\n" + str);
                    }
                }
           catch(Exception e)
                {
                    System.out.println("4");
                }
             }
         }
        }
         catch(Exception e)
         {
            Dialog.show("Happy to help",e.getMessage(), "OK", null);
         }
    }
  
    public int getNum()
    {
        int type = 0;
        byte[] byteInputData = new byte[5];
        
        try
        {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(byteInputData);
            DataInputStream inputDataStream = new DataInputStream(inputStream);
            comparator = new Comparator();
            recordstore = RecordStore.openRecordStore("indexStore", true );
            recordEnumeration = recordstore.enumerateRecords(null, comparator, false);

            if (recordstore.getNumRecords() > 0)
            {
                while (recordEnumeration.hasNextElement())
                {
                    recordstore.getRecord( recordEnumeration.nextRecordId(),byteInputData, 0);
                    type =  inputDataStream.readInt();
                }
                inputDataStream.reset();
               recordstore.closeRecordStore();
        
            }
        }
        catch(Exception e)
        {
         }

        return(type);

    }

    public void readRecord()
    {
        int z = 0;
        byte[] byteInputData = new byte[300];

        ByteArrayInputStream inputStream = new ByteArrayInputStream(byteInputData);
        DataInputStream inputDataStream = new DataInputStream(inputStream);
        comparator = new Comparator();
        try
        {
            recordstore = RecordStore.openRecordStore("myRecordStore", true );
            recordEnumeration = recordstore.enumerateRecords(null, comparator, false);

            stringElements =  new String[recordstore.getNumRecords()];
            phone =  new String[recordstore.getNumRecords()];
            
            while (recordEnumeration.hasNextElement())
            {
                recordstore.getRecord( recordEnumeration.nextRecordId(),byteInputData, 0);
                stringElements[z] = inputDataStream.readUTF();
                phone[z] = inputDataStream.readUTF();
                inputDataStream.reset();
                z++;
            }
            recordstore.closeRecordStore();
        }
        catch(Exception e)
        {
        }

       }


    private static class AlternateImageRenderer extends Label implements ListCellRenderer {

        public AlternateImageRenderer() {
            super("");
        
        }

        public Component getListCellRendererComponent(List list, Object value, int index, boolean isSelected) {

            setText(value.toString());
            if (isSelected) {
                setFocus(true);
                 getStyle().setBgTransparency(100);
                 getStyle().setBgColor(1);
            } else {
                setFocus(false);
                getStyle().setBgTransparency(0);
            }
            return this;
        }

        public Component getListFocusComponent(List list) {
            setText("");
            setFocus(true);
            getStyle().setBgTransparency(100);
            return this;
        }
    }
}


class Comparator implements RecordComparator
{
    private byte[] comparatorInputData = new byte[300];
    private ByteArrayInputStream comparatorInputStream = null;
    private DataInputStream comparatorInputDataType = null;
    public int compare(byte[] record1, byte[] record2)
        {
        int record1int, record2int;
        try
        {
            int maxlen = Math.max(record1.length, record2.length);
            if (maxlen > comparatorInputData.length)
            {
                comparatorInputData = new byte[maxlen];
            }
            comparatorInputStream = new ByteArrayInputStream(record1);
            comparatorInputDataType =new DataInputStream(comparatorInputStream);
            comparatorInputDataType.readUTF();
            record1int = comparatorInputDataType.readInt();
            comparatorInputStream = new ByteArrayInputStream(record2);
            comparatorInputDataType = new DataInputStream(comparatorInputStream);
            comparatorInputDataType.readUTF();
            record2int = comparatorInputDataType.readInt();
            if (record1int == record2int)
            {
                return RecordComparator.EQUIVALENT;
            }
            else if (record1int < record2int)
            {
                return RecordComparator.PRECEDES;
            }
            else
            {
                return RecordComparator.FOLLOWS;
            }
        }
        catch (Exception error)
        {
             return RecordComparator.EQUIVALENT;
        }
    }
    public void compareClose()
    {
        try
        {
            if (comparatorInputStream!= null)
            {
                comparatorInputStream.close();
            }
            if (comparatorInputDataType!= null)
            {
                comparatorInputDataType.close();
            }
        }

        /* author Venkata Narasimhan, A
         * (c) all rights reserved */

        catch (Exception error)
        {
        }
    }
}


