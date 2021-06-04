package utilities;

import exception.*;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtils {
	
	public static final String FORMAT_DATE_ES = "d/M/yyyy";

	public static String [] splitLine(String line){
		return line.split(";");
		//return line.split("\\?+");
	}



	public static boolean validateReadName(String wordString) throws ExceptionReadName {
		Pattern pat = Pattern.compile("^[A-Z][a-z]+");
		Matcher mat = pat.matcher(wordString);
		if (mat.matches())
			return true;
		else
			throw new ExceptionReadName();
	}

	public static LocalDate parseDateToLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static LocalDate toDate( String stringDate ) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( "MM/dd/yyyy" );
		return LocalDate.parse( stringDate, dateTimeFormatter );
	}
	
	public static boolean validateDate( String dateString ) throws DateFormatException {
		Pattern pat = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[/\\\\/](19|20)\\d{2}$");
		Matcher mat = pat.matcher( dateString );
		if (mat.matches()){
			return true;
		} else {
			throw new DateFormatException();
		}
	}

	public static TableColumn getModelColumn(JTable table, int numCol, int minWidth, int maxWidth ) {
		TableColumn column;
		column = table.getColumnModel().getColumn(numCol);
//		column.setPreferredWidth(minWidth);
		column.setMaxWidth( maxWidth );
		column.setMinWidth( minWidth );
		return column;
	}

	public static String toStringLocalDate(LocalDate localDate){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
		return localDate.format(formatter);

	}

	public static void setMainElementsButton(JButton jButton, ImageIcon imageIcon, int top, int left, int bottom, int right){
		jButton.setBackground(Color.WHITE);
		jButton.setIcon(imageIcon);
		jButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		jButton.setBorder(null);
		jButton.setBorder(BorderFactory.createEmptyBorder(top,left,bottom,right));
	}

	public static void setTextAndIconButtons(JButton button, String text, ImageIcon imageIcon, int top, int left, int bottom, int right){
		button.setFont(new Font("Arial", Font.BOLD, 18));
		button.setText(text);
		button.setForeground(Color.BLUE);
		button.setMaximumSize(new Dimension(380,100));
		button.setBackground(null);
		button.setIcon(imageIcon);
		button.setAlignmentX(Component.LEFT_ALIGNMENT);
		button.setBorder(null);
	}

    public static Properties generateProperties(String pathFile) throws IOException {
		Properties properties = new Properties();
		InputStream input = new FileInputStream(pathFile);
		properties.load(input);
		return properties;
    }

    public static void saveProperties(Properties properties,String pathFile) throws IOException {
		FileOutputStream output = new FileOutputStream(pathFile);
		properties.store(output,null);
		output.close();

	}

}