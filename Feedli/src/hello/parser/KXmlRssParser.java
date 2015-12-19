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

package hello.parser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParser;

public class KXmlRssParser
{
	public Vector parse(String rssUrl) throws Exception
	{
		Vector items = new Vector();
		
		KXmlParser parser = new KXmlParser();
		
		HttpConnection conn = (HttpConnection)Connector.open(rssUrl);
		
		InputStream rssStream = conn.openInputStream();
		
		InputStreamReader isr = new InputStreamReader(rssStream);
		
		parser.setInput(isr);
		
		parser.nextTag();
		
		parser.require(XmlPullParser.START_TAG, null, "rss");
		
		parser.nextTag();
		
		parser.require(XmlPullParser.START_TAG, null, "channel");
		
		parser.nextTag();
		
		while(parser.getEventType() != XmlPullParser.END_TAG)
		{
			String nodeName = parser.getName();
			
			if(nodeName.compareTo("item") == 0)
			{
				items.addElement(parseRssItem(parser));
			}
			else
			{
				parser.skipSubTree();
			}
			parser.nextTag();
		}
		
		isr.close();
		
		rssStream.close();
		
		conn.close();
		
		return items;
	}
	RssItem parseRssItem(KXmlParser parser) throws Exception
	{
		RssItem item = new RssItem();
		
		parser.nextTag();

		while(parser.getEventType() != XmlPullParser.END_TAG)
		{
			String nodeName = parser.getName();
			
			if(nodeName.compareTo("title") == 0)
			{
				item.title = parser.nextText();
			}
			else if(nodeName.compareTo("description") == 0)
			{
				item.description = parser.nextText();
			}
			else if(nodeName.compareTo("link") == 0)
			{
				item.link = parser.nextText();
			}
			else
			{
				parser.skipSubTree();
			}
			parser.nextTag();
		}
		return item;
	}
}
