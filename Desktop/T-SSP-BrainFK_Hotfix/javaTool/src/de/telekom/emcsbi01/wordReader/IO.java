package de.telekom.emcsbi01.wordReader;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class to open and export Word-Document in *.docx type. Not working on old *.doc format. <br>
 * @author Nico Remus <br>
 * @coauthor Philipp Staats<br>
 * T-System Internationl GmbH<br>
 * @version 1.0
 */
public class IO {
    private WordAPI word;
    private File projectPath;

	/**
	 * constructor class - generates the project/app path
	 */
	public IO(){
		generateProjectPath();
    }

	/**
	 * analyze current project/app path
	 */
    private void generateProjectPath(){
	    Path currentRelativePath = Paths.get("");
	    String s = currentRelativePath.toAbsolutePath().toString();
	    System.out.println("Current relative path is: " + s);
	    projectPath = new File(s);
    }

	/**
	 * start swing JFileChooser - OpenDialog and load with Apache POI the word file as object<br>
	 * Used classes/API:
	 * <ul>
	 *     <li>Apache POI:{@link org.apache.poi.xwpf.usermodel.XWPFDocument}</li>
	 *     <li>Swing: {@link JFileChooser}</li>
	 * </ul>
	 */
	public void loadWordFile(){
	    JFileChooser chooser = new JFileChooser(projectPath);
	    chooser.setCurrentDirectory(projectPath);
	    chooser.showOpenDialog(null);

		//TODO CHECK PROTECTION: FILE CHOOSED
		//TODO FILE PROTECTION: SET FILTER TO DOCX
	    File inputFile = new File(chooser.getSelectedFile().getPath());
	    FileInputStream in;
	    try {
		    in = new FileInputStream(inputFile);
		    word = new WordAPI(in);
	    }
	    catch (IOException e) {e.printStackTrace();}
    }

    public void write2Console(){
        word.readCompleteWordFile();
    }

    public WordAPI getWord() {
        return word;
    }

    public void setWord(WordAPI word) {
        this.word = word;
    }

	public File getProjectPath() {
		return projectPath;
	}

	public void setProjectPath(File projectPath) {
		this.projectPath = projectPath;
	}
}