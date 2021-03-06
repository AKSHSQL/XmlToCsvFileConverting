package covert;

public class MainMethodForConverting {

    public static final String inputfilePath = "";
    public static final String outputfilePath = "";
    public static final String xmlFileName = "";
    public static final String xlsFileName = "";
    public static final String outputFileName = "";

    public static void main(String[] args) {

        XmlToCsvFileCoverter xmlToCsvFileCoverter =  new XmlToCsvFileCoverter();
        xmlToCsvFileCoverter.convertXmlToCsvFile(inputfilePath+xmlFileName, inputfilePath+xlsFileName, outputfilePath+outputFileName);
    }


}
