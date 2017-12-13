package Test;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

public class Test extends Applet {
	
	int       aFields[][];      //Brett mit allen Feldern
	Image     image;            //Bildspeicher
	int       bordersize;       //Randbreite
	Dimension fieldsize;        //Größe eines Feldes
	Dimension imagesize;        //Größe des Bildes
	Point     sourcefield;      //Bei Mausklick ausgewähltes Feld
	Point     lastpoint;        //Ursprung des letzten Rechtecks
	Point     drawoffset;       //Offset zur Mausdragposition
	
	public void init()
	{
	   int[][] aFields = new int[4][4];
	   sourcefield = new Point(-1, -1);
	   lastpoint = new Point(-1, -1);
	   drawoffset = new Point(0,0);
	   bordersize = Integer.parseInt(getParameter("bordersize"));
	   if (bordersize < 1 || bordersize > 50) {
	      bordersize = 5;
	   }
	   setBackground(Color.lightGray);
	   addMouseListener(new MyMouseListener());
	   addMouseMotionListener(new MyMouseMotionListener());
	   prepareImage();
	   randomizeField(true);
	}
	
	/**
	 * Lädt das Bild.
	 */
	private void prepareImage()
	{
	   //Bild laden
	   image = getImage(getDocumentBase(),getParameter("src"));
	   MediaTracker mt = new MediaTracker(this);
	   mt.addImage(image, 0);
	   try {
	      //Warten, bis das Image vollständig geladen ist,
	      mt.waitForAll();
	   } catch (InterruptedException e) {
	      //nothing
	   }
	   imagesize        = new Dimension();
	   imagesize.height = image.getHeight(this);
	   imagesize.width  = image.getWidth(this);
	}
	
	/**
	 * Mischt die Steine auf dem Spielfeld.
	 */
	private void randomizeField(boolean unordered)
	{
	   int i, j, k, tmp;

	   //Zuerst sortieren...
	   for (i = 0; i <= 15; ++i) {
	      aFields[i / 4][i % 4] = i;
	   }
	   //Dann mischen...
	   if (unordered) {
	      Random rand = new Random(System.currentTimeMillis());
	      for (i = 0; i < 20; ++i) {
	         j = Math.abs(rand.nextInt()) % 16;
	         k = Math.abs(rand.nextInt()) % 16;
	         tmp = aFields[j / 4][j % 4];
	         aFields[j / 4][j % 4] = aFields[k / 4][k % 4];
	         aFields[k / 4][k % 4] = tmp;
	      }
	   }
	}
	
	/**
	 * Mischt die Steine auf dem Spielfeld.
	 */
	private void randomizeField(boolean unordered)
	{
	   int i, j, k, tmp;

	   //Zuerst sortieren...
	   for (i = 0; i <= 15; ++i) {
	      aFields[i / 4][i % 4] = i;
	   }
	   //Dann mischen...
	   if (unordered) {
	      Random rand = new Random(System.currentTimeMillis());
	      for (i = 0; i < 20; ++i) {
	         j = Math.abs(rand.nextInt()) % 16;
	         k = Math.abs(rand.nextInt()) % 16;
	         tmp = aFields[j / 4][j % 4];
	         aFields[j / 4][j % 4] = aFields[k / 4][k % 4];
	         aFields[k / 4][k % 4] = tmp;
	      }
	   }
	}
	
	public void paint(Graphics g)
	{
	   paintBorder(g);
	   paintField(g);
	}
	
	/**
	 * Zeichnet den Rahmen des Spielbretts.
	 */
	private void paintBorder(Graphics g)
	{
	   Insets insets    = getInsets();
	   Dimension size   = getSize();
	   size.height      -= insets.top + insets.bottom;
	   size.width       -= insets.left + insets.right;
	   fieldsize        = new Dimension();
	   fieldsize.width  = (size.width - (2 * bordersize)) / 4;
	   fieldsize.height = (size.height - (2 * bordersize)) / 4;
	   g.setColor(Color.black);
	   g.drawRect(
	      insets.left,
	      insets.top,
	      size.width  - 1,
	      size.height - 2
	   );
	   g.drawRect(
	      insets.left + bordersize,
	      insets.top  + bordersize,
	      4 * fieldsize.width,
	      4 * fieldsize.height
	   );
	}

	public void paint(Graphics g)
	{
	   paintBorder(g);
	   paintField(g);
	}

	/**
	 * Zeichnet den Rahmen des Spielbretts.
	 */
	private void paintBorder(Graphics g)
	{
	   Insets insets    = getInsets();
	   Dimension size   = getSize();
	   size.height      -= insets.top + insets.bottom;
	   size.width       -= insets.left + insets.right;
	   fieldsize        = new Dimension();
	   fieldsize.width  = (size.width - (2 * bordersize)) / 4;
	   fieldsize.height = (size.height - (2 * bordersize)) / 4;
	   g.setColor(Color.black);
	   g.drawRect(
	      insets.left,
	      insets.top,
	      size.width  - 1,
	      size.height - 2
	   );
	   g.drawRect(
	      insets.left + bordersize,
	      insets.top  + bordersize,
	      4 * fieldsize.width,
	      4 * fieldsize.height
	   );
	}
	
	/**
	 * Zeichnet die Spielsteine auf dem Brett.
	 */
	private void paintField(Graphics g)
	{
	   int imagenumber, image_i, image_j;
	   Insets insets = getInsets();
	   Point topleft = new Point();
	   topleft.x     = insets.left + bordersize;
	   topleft.y     = insets.top  + bordersize;
	   g.setColor(Color.black);
	   for (int i = 0; i <= 3; ++i) {
	      for (int j = 0; j <= 3; ++j) {
	         imagenumber = aFields[i][j];
	         if (imagenumber == 15) {
	            //Lücke zeichnen
	            g.fillRect(
	               topleft.x + j * fieldsize.width,
	               topleft.y + i * fieldsize.height,
	               fieldsize.width,
	               fieldsize.height
	            );
	         } else {
	            //Image darstellen
	            image_i = imagenumber / 4;
	            image_j = imagenumber % 4;
	            g.drawImage(
	               image,
	               topleft.x + j * fieldsize.width,
	               topleft.y + i * fieldsize.height,
	               topleft.x + j * fieldsize.width + fieldsize.width,
	               topleft.y + i * fieldsize.height + fieldsize.height,
	               image_j * (imagesize.width / 4),
	               image_i * (imagesize.height / 4),
	               image_j * (imagesize.width/4) + imagesize.width/4,
	               image_i * (imagesize.height/4) + imagesize.height/4,
	               this
	            );
	            //Rahmen
	            g.drawRect(
	               topleft.x + j * fieldsize.width,
	               topleft.y + i * fieldsize.height,
	               fieldsize.width,
	               fieldsize.height
	            );
	            //Beschriftung
	            g.drawString(
	               "" + imagenumber,
	               topleft.x + j * fieldsize.width + 2,
	               topleft.y + i * fieldsize.height + 12
	            );
	         }
	      }
	   }
	}
	
	public void update(Graphics g)
	{
	   Image     dbImage;
	   Graphics  dbGraphics;

	   //Double-Buffer initialisieren
	   dbImage = createImage(getSize().width,getSize().height);
	   dbGraphics = dbImage.getGraphics();
	   //Hintergrund löschen
	   dbGraphics.setColor(getBackground());
	   dbGraphics.fillRect(0,0,getSize().width,getSize().height);
	   //Vordergrund zeichnen
	   dbGraphics.setColor(getForeground());
	   paint(dbGraphics);
	   //Offscreen-Image anzeigen
	   g.drawImage(dbImage,0,0,this);
	   dbGraphics.dispose();
	}
	
	public void mousePressed(MouseEvent event)
	{
	   sourcefield = getFieldFromCursor(event.getX(), event.getY());
	   if (sourcefield.x == -1 || sourcefield.y == -1) {
	      swapRandomization();
	      repaint();
	   }
	   lastpoint.x = -1;
	   lastpoint.y = -1;
	}
	
	private Point getFieldFromCursor(int x, int y)
	{
	   Insets insets = getInsets();
	   Point topleft = new Point();
	   topleft.x     = insets.left + bordersize;
	   topleft.y     = insets.top  + bordersize;
	   Point ret     = new Point(-1, -1);
	   if (x >= topleft.x) {
	      if (x < topleft.x + 4 * fieldsize.width) {
	         if (y >= topleft.y) {
	            if (y < topleft.y + 4 * fieldsize.height) {
	               ret.x = (x - topleft.x) / fieldsize.width;
	               ret.y = (y - topleft.y) / fieldsize.height;
	               drawoffset.x = x - topleft.x -
	                              ret.x * fieldsize.width;
	               drawoffset.y = y - topleft.y -
	                              ret.y * fieldsize.height;
	            }
	         }
	      }
	   }
	   return ret;
	}
	
	/**
	 * Kehrt die Steineordnung um: falls sie sortiert sind,
	 * werden sie gemischt und umgekehrt.
	 */
	private void swapRandomization()
	{
	   //Sind die Felder sortiert?
	   boolean sorted = true;
	   for (int i = 0; i <= 15; ++i) {
	      if (aFields[i / 4][i % 4] != i) {
	         sorted = false;
	         break;
	      }
	   }
	   //Neu mischen bzw. sortieren
	   randomizeField(sorted);
	}

	/**
	 * Maustaste losgelassen.
	 */
	public void mouseReleased(MouseEvent event)
	{
	   if (sourcefield.x != -1 && sourcefield.y != -1) {
	      Point destfield;
	      destfield = getFieldFromCursor(event.getX(), event.getY());
	      if (destfield.x != -1 && destfield.y != -1) {
	         if (aFields[destfield.y][destfield.x] == 15) {
	            if (areNeighbours(sourcefield, destfield)) {
	               aFields[destfield.y][destfield.x] =
	                  aFields[sourcefield.y][sourcefield.x];
	               aFields[sourcefield.y][sourcefield.x] = 15;
	            }
	         }
	      }
	      repaint();
	   }
	   sourcefield.x = -1;
	   sourcefield.y = -1;
	}
	
	/**
	 * Maus wurde bei gedrückter Taste bewegt.
	 */
	public void mouseDragged(MouseEvent event)
	{
	   if (sourcefield.x != -1 && sourcefield.y != -1) {
	      Graphics g = getGraphics();
	      g.setXORMode(getBackground());
	      g.setColor(Color.black);
	      //Das zuletzt gezeichnete Rechteck entfernen
	      if (lastpoint.x != -1) {
	         g.drawRect(
	            lastpoint.x - drawoffset.x,
	            lastpoint.y - drawoffset.y,
	            fieldsize.width,
	            fieldsize.height
	         );
	      }
	      //Neues Rechteck zeichnen
	      g.drawRect(
	         event.getX() - drawoffset.x,
	         event.getY() - drawoffset.y,
	         fieldsize.width,
	         fieldsize.height
	      );
	      lastpoint.x = event.getX();
	      lastpoint.y = event.getY();
	      g.dispose();
	   }
	}

}
