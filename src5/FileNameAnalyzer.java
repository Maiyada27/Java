public class FileNameAnalyzer {

    public static void main(String[] args){
        String base = "";
        String extension = "";
        String classification = "";
        String fileName = IO.readln("Enter File Name: ");
        boolean isValid= false;

        /*check if file is in the right format, then extract file name and extension*/
        if(!fileName.contains(".") || fileName.startsWith(".") || fileName.endsWith(".") || fileName.isBlank()){
            IO.println("Invalid file name.");
        }else{
            int index = fileName.lastIndexOf(".");
            base = fileName.substring(0,index).toLowerCase();
            extension = fileName.substring(index+1, fileName.length()).toLowerCase();
            isValid =true;

        }
        /*check the extension to classify the file*/
        if(isValid == true){
            if(extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("txt") || extension.equalsIgnoreCase("docx") ){
                classification = "Document";
            } else if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("gif")) {
                classification = "Image";
            } else if (extension.equalsIgnoreCase("mp3") || extension.equalsIgnoreCase("wav")){
                classification = "Audio";
            }else{
                classification = "Other";
            }

            IO.println("Base name: " + base);
            IO.println("Extension: " + extension);
            IO.println("Classification: " + classification);}


    }
}
