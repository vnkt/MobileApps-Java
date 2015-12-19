/***
 * 
 * Copyright (C) 2008 Alessandro La Rosa
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * Contact: alessandro.larosa@gmail.com
 *
 * Author: Alessandro La Rosa
 */

package hello.display;

import java.util.Vector;

import javax.microedition.lcdui.List;

import hello.parser.KXmlRssParser;
import hello.parser.RssItem;

public class TitleList extends List
{
	public TitleList()
	{
		super("Rss Feed", List.IMPLICIT);
		
		KXmlRssParser parser = new KXmlRssParser();
                append("Elements",null);
                System.out.println("Helklo");
		
		try
		{
			Vector rssItems = parser.parse("http://sports.espn.go.com/espn/rss/news");

			for(int i = 0; i < rssItems.size(); i++)
			{
                                System.out.println("Loop "+i);
				append(((RssItem)rssItems.elementAt(i)).title, null);
                                

                                String s = (String) ((RssItem)rssItems.elementAt(i)).description;
                                System.out.println("Actual rss "+s);
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
                                    }
                                    else
                                    {
                                        if(output != null )output = output + s.charAt(count);
                                        else output = " " + s.charAt(count);
                                        count++;
                                    }
                                }
                                append(output, null);
                                }
                }
		catch(Exception e)
		{
			append("Error: " + e, null);
			
			e.printStackTrace();
		}
	}
}
