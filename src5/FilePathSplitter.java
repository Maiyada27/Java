public class FilePathSplitter {

    public static void main(String[] args) {
        String path = IO.readln("Enter path: ");
        boolean hadBackSlash = false;
        String extension ="";

        /*check if path is blank, if it is blank stop and return.*/
        if (path.isBlank()) {
            IO.println("Invalid path.");
            return;
        }
        /*check if it contains backslash and if it does replace it with /*/
        if (path.contains("\\")){
            path= path.replace("\\", "/");
            hadBackSlash = true;
        }
        /*get the file name and check if it contains an extension.*/
        int index = path.lastIndexOf("/");
        String fileName = path.substring(index+1, path.length());
        String folder = path.substring(0,index+1);
        if (fileName.contains(".")){
            int indexDot = fileName.lastIndexOf(".");
            extension = fileName.substring(indexDot+1).toLowerCase();
        }else{
            extension = "none.";
        }

        IO.println("Folder: " + folder);
        IO.println("File name: " + fileName);
        IO.println("Extension: " + extension);

        if(hadBackSlash){
            IO.println("WindowsPath");
        }else{
            IO.println("UnixPath");
        }

    }

}
