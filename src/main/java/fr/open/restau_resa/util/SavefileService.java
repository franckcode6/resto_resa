package fr.open.restau_resa.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SavefileService {

	protected final static String IMAGE_FOLDER = "src/main/Webapp/images/";

	/**
	 * Method to save image file
	 * 
	 * @param nom
	 * @param multipartFile
	 * @throws IOException
	 */
	public void saveFile(String nom, MultipartFile multipartFile) throws IOException {
		Path chemin = Paths.get(IMAGE_FOLDER);

		if (!Files.exists(chemin)) {
			Files.createDirectories(chemin);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path cheminFichier = chemin.resolve(nom);
			System.out.println(cheminFichier);
			Files.copy(inputStream, cheminFichier, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Erreur d'écriture : " + nom, ioe);
		}
	}
}
