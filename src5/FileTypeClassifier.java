import java.util.ArrayList;
import java.util.List;

public class FileTypeClassifier {

    public static void main(String[] args) {
        String[] allFiles = {"Project.pdf", "album.jpg", "draft.docx", "final.png", "code.java", "drafts.pdf", "attempt", "trial.js"};
        List<String> files = new ArrayList<>();
        int document = 0;
        int image = 0;
        int code = 0;
        int other = 0;
        String classification = "";
        String extension = "";
        String base = "";
        boolean isValid = false;

        for (String f : allFiles) {
            files.add(f);
        }

        for (int i = 0; i <= files.size() - 1; i++) {
            if (!files.get(i).contains(".")) {
                other += 1;
                classification = "other";
                IO.println("File name: (" + files.get(i) +"). Invalid file name.");

            } else {
                int index = files.get(i).lastIndexOf(".");
                base = files.get(i).substring(0, index).toLowerCase();
                extension = files.get(i).substring(index + 1, files.get(i).length()).toLowerCase();
                isValid = true;
            }
            if (isValid == true) {
                if (extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("txt") || extension.equalsIgnoreCase("docx")) {
                    classification = "Document";
                    document +=1;
                } else if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("gif")) {
                    classification = "Image";
                    image +=1;
                } else if (extension.equalsIgnoreCase("java") || extension.equalsIgnoreCase("py") || extension.equalsIgnoreCase("js")) {
                    classification = "Code";
                    code +=1;
                } else {
                    classification = "Other";
                    other +=1;
                }

                IO.println("Base name: " + base);
                IO.println("Extension: " + extension);
                IO.println("Classification: " + classification);
            }

        }

        IO.println("Number of documents: " + document);
        IO.println("Number of images: " + image);
        IO.println("Number of code files: " + code);
        IO.println("Others: " + other);
        IO.println("Total number of files: " + files.size());
    }
}
