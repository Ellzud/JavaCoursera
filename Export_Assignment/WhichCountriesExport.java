/**
 * Reads a chosen CSV file of country exports and prints each country that exports coffee.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
    public void listExporters(CSVParser parser, String exportOfInterest) {
        //for each row in the CSV File
        for (CSVRecord record : parser) {
            //Look at the "Exports" column
            String export = record.get("Exports");
            //Check if it contains exportOfInterest
            if (export.contains(exportOfInterest)) {
                //If so, write down the "Country" from that row
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }

    public void whoExportsCoffee() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");
    }
    
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser, "Nauru"));
        
        //parser = fr.getCSVParser();
        //listExportersTwoProducts(parser, "fish", "nuts");
        
        //parser = fr.getCSVParser();
        //int numberCountries = numberOfExporters(parser, "gold");
        //System.out.println("# of countries exporting: " + numberCountries);
        
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }
    
    public String countryInfo(CSVParser parser, String country) {
        int cfound = 0;
        String result = "";
        for (CSVRecord record : parser) {
            String c = record.get("Country");
            if (c.contains(country)) {
                String cOne = record.get("Country");
                String cTwo = record.get("Exports");
                String cThree = record.get("Value (dollars)");
                result = cOne + ": " + cTwo + ": " + cThree;
                cfound = 1;
                break;
            } 
        }
        if (cfound == 1) {
            return result;
        } else {
            return ("NOT FOUND");
        }
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportItem1) && export.contains(exportItem2)) {
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem) {
        int countCountry =0;
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportItem)) {
                countCountry++;
            }
        }
        return countCountry;
    }
    
    public void bigExporters (CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String money = record.get("Value (dollars)");
            String country = record.get("Country");
            if (amount.length()< money.length()) {
                System.out.println(country + " " + money);
            }
        }
    }
    
}
