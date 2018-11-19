package prj5;

/**
 * @(#)urlConnectionWiki.java
 *
 * This is a proof of concept program that tells the user the birthday of whatever celebrity they are intersted in
 * It uses Wikipedia to find the information.
 *
 * Updates to make: Accept single names,
 * rewrite the date string into a nicer format, if the Wikipedia page doesn't exist for the normal format, try alternate format.
 * Rewrite as a class, use a GUI to instantiate.
 *
 * @author Alison DiBenedetto
 *
 * @version 1.00 2015/11/1
 */




import javax.print.attribute.standard.MediaSize;
import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.Scanner;

public class urlConnectionwiki {
	private static final String NAME = "Name";
	private static final String SYMBOL = "Symbol";
	private static final String ATOMIC_NUMBER = "Atomic number";
	private static final String REL_MASS = "Relative atomic mass";
	private static final String STANDARD_STATE = "Standard state";
	private static final String APPEARANCE = "Appearance";
	private static final String CLASSIFICATION = "Classification";


	private static final String GROUP_IN_TABLE = "Group in periodic table";
	private static final String GROUP_NAME = "Group name";
	private static final String PERIOD = "Period in periodic table";
	private static final String BLOCK = "Block in periodic table";
	private static final String SHELL_STRUCTURE = "Shell structure";
	private static final String CAS_REG = "CAS Registry";

	private static final String DENSITY = "Density of solid";
	private static final String MOLAR_VOLUME = "Molar volume<";
	private static final String THERMAL_CONDUCTIVITY = "Thermal conductivity<";

	private static final String MELTING_POINT = "Melting point<";
	private static final String BOILING_POINT = "Boiling point<";
	private static final String ENTHALPY = "Enthalpy of fusion<";


	public urlConnectionwiki() {};
/*
	public boolean getElement(String eName, Element element){
		String celeb=eName;

		while (true){

			try{
				int spaceIndex = celeb.indexOf(" ");

				if(spaceIndex>-1)
				{
					celeb.toLowerCase();
					String firstName = celeb.substring(0, spaceIndex).trim();
					String lastName = celeb.substring(spaceIndex+1).trim();

					char c = Character.toUpperCase(firstName.charAt(0));
					firstName = c + firstName.substring(1);
					c = Character.toUpperCase(lastName.charAt(0));
					lastName = c + lastName.substring(1);

					String wikiPage = "https://en.wikipedia.org/wiki/"+firstName+"_"+lastName;
					URL wiki = new URL(wikiPage);
					URLConnection yc = wiki.openConnection();
					BufferedReader in = new BufferedReader(new InputStreamReader(
							yc.getInputStream()));

					String inputLine;
					String line="";

					while ((inputLine = in.readLine()) != null)
						line+=inputLine;

					in.close();
					int pos=0;

					pos = line.indexOf("bday", pos+1);
					if(pos>-1)
					{
						int endbdayIndex = line.indexOf("</span>", pos+1);
						String bday = line.substring(pos+6, endbdayIndex);
						System.out.println("born: " + bday);
					}
					else
						System.out.println("We don't know");
				}
				else
					System.out.println("We need a first and last name");
			}
			catch(FileNotFoundException ex)
			{
				System.out.println("unknown");
			}
			catch(MalformedURLException e)
			{
				System.out.println("badly formed url exception occurred");
				return false;
			}
			catch(IOException e)
			{
				System.out.println("IO exception occurred");
				return false;
			}
		}//end of while
	}

*/
private static String getInfo(String line, int spot){
	int start = line.indexOf(":", spot)+2;
	int end = line.indexOf("<", start);
	return line.substring(start, end);
}
    public static void main(String[] args)  {

//		Scanner reader = new Scanner(System.in);
		String celeb="gold";
		CElement element = new CElement();

		while (true){

			try{

	//			System.out.println("Who is your favorite celebrity? (type quit if done)");
	//			celeb = reader.nextLine();
	//			celeb=celeb.trim();
	//			if(celeb.equals("quit"))
	//				break;

	//			int spaceIndex = celeb.indexOf(" ");

	//			if(spaceIndex>-1)
	//			{
					celeb.toLowerCase();

					//String wikiPage = "https://en.wikipedia.org/wiki/"+celeb + "_(element)";
					celeb = celeb.toLowerCase().trim() + "/";
					String website = "https://www.webelements.com/" + celeb;
					URL wiki = new URL(website);
					URLConnection yc = wiki.openConnection();
					BufferedReader in = new BufferedReader(new InputStreamReader(
							yc.getInputStream()));

					String inputLine;
					String line="";

					while ((inputLine = in.readLine()) != null)
						line+=inputLine;

					in.close();

					int spot = -1;
					String prop="";

					//get general properties
					spot = line.indexOf(NAME);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.genProperty.setName(prop);
					}

					spot = line.indexOf(SYMBOL);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.genProperty.setSymbol(prop);
					}
					spot = line.indexOf(ATOMIC_NUMBER);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.genProperty.setAtomicNumber(prop);
					}

					spot = line.indexOf(REL_MASS);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.genProperty.setRelMass(prop);
					}

					spot = line.indexOf(STANDARD_STATE);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.genProperty.setStdState(prop);
					}

					spot = line.indexOf(APPEARANCE);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.genProperty.setAppearance(prop);
					}

					spot = line.indexOf(CLASSIFICATION);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.genProperty.setClassification(prop);
					}

					System.out.println( element.genProperty.toString());

					//get periodic table
					spot = line.indexOf(GROUP_IN_TABLE);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.periodicTable.setGroup(prop);
					}

					spot = line.indexOf(GROUP_NAME);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.periodicTable.setGroupName(prop);
					}

					spot = line.indexOf(PERIOD);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.periodicTable.setPeriod(prop);
					}

					spot = line.indexOf(BLOCK);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.periodicTable.setBlock(prop);
					}

					spot = line.indexOf(SHELL_STRUCTURE);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.periodicTable.setShellStructure(prop);
					}

					spot = line.indexOf(CAS_REG);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.periodicTable.setCASReg(prop);
					}

					System.out.println( element.periodicTable.toString());

					//physical property
					spot = line.indexOf(DENSITY);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.phyProperty.setDensity(prop);
					}

					spot = line.indexOf(MOLAR_VOLUME);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.phyProperty.setMolarVol(prop);
					}

					spot = line.indexOf(THERMAL_CONDUCTIVITY);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.phyProperty.setThermConduct(prop);
					}
					System.out.println( element.phyProperty.toString());

					//heat property
					spot = line.indexOf(MELTING_POINT);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.heatProperty.setMeltingPoint(prop);
					}

					spot = line.indexOf(BOILING_POINT);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.heatProperty.setBoilingPoint(prop);
					}

					spot = line.indexOf(ENTHALPY);
					if (spot != -1) {
						prop = getInfo(line, spot);
						element.heatProperty.setEnthalpy(prop);
					}
					System.out.println( element.heatProperty.toString());
					int n=0;


/*
					pos = line.indexOf("Personal details", pos+1);
					if(pos>-1)
					{
						int endbdayIndex = line.indexOf("</span>", pos+1);
						String bday = line.substring(pos+6, endbdayIndex);
						System.out.println("born: " + bday);
					}
					else
						System.out.println("We don't know");
				}*/
	//			else
	//				System.out.println("We need a first and last name");
			}
			catch(FileNotFoundException ex)
			{
				System.out.println("unknown");
			}
			catch(MalformedURLException e)
			{
				System.out.println("badly formed url exception occurred");
				return;
			}
			catch(IOException e)
			{
				System.out.println("IO exception occurred");
				return;
			}


		}

	}//endmain

}//endclass

