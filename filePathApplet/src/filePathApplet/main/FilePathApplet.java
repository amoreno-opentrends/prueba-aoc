package filePathApplet.main;

import java.applet.Applet;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;

import netscape.javascript.JSObject;

public class FilePathApplet extends Applet{

	private static final long serialVersionUID = 1L;

	public void init(){
		Object [] args = {this};
		JSObject jso = (JSObject)JSObject.getWindow(this);
		jso.call("inicialitzaApplet", args);
	}
	
	public void selecciona(String tipusFitxer){
		JSObject jso = (JSObject)JSObject.getWindow(this);
		Frame parent = new Frame();
		FileDialog fd = new FileDialog(parent, "Selecciona el fitxer...", 0);
		fd.setFile(tipusFitxer);
		fd.setVisible(true);
		String selectedItem = fd.getFile();
		if (selectedItem != null) {
			File ffile = new File(fd.getDirectory() + File.separator + fd.getFile());
			jso.call("afegirFitxer", new Object [] {ffile.getPath(),ffile.getParent(),ffile.getName().substring(ffile.getName().length()-3)});
		}
	}
	
}
