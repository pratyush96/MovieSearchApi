package com.movies.service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

import com.movies.repository.*;
import com.movies.model.*;

//  LOAD EXCEL FROM GIVEN PATH AS ARGUEMENT AND POPULATE TABLE

@Service
public class MovieService {

@Autowired
private MovieRepository movieRepository;
private MovieModel movieModel;
public void ReadDataFromExcel(String excelPath) throws EncryptedDocumentException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

Workbook workbook = WorkbookFactory.create(new File(excelPath));

Sheet sheet=workbook.getSheetAt(0);
Iterator<Row> itr = sheet.iterator();  
for (int rn=1; rn<=sheet.getLastRowNum(); rn++) {
Row  row = sheet.getRow(rn);
MovieModel mv= new MovieModel(row);
movieRepository.save(mv);

}
// MovieModel m= new MovieModel();
// for (int r=1; r<=sheet.getLastRowNum(); r++) {
// Row  row1 = sheet.getRow(r);
// m.objectMapper(row1);
// movieRepository.save(m);


/*
*
*
for(Sheet sheet: workbook) {
for (Row row: sheet) {

String movieId = row.getCell(0).getStringCellValue();
        String type = row.getCell(1).getStringCellValue();
        String title =  row.getCell(2).getStringCellValue();
        String director =  row.getCell(3).getStringCellValue();
        String cast =  row.getCell(4).getStringCellValue();
        String country =  row.getCell(5).getStringCellValue();
       
       
        MovieModel mv = new MovieModel();
        mv.setMovieId(movieId);
        mv.setMovieType(type);
        mv.setTitle(title);
        mv.setDirector(director);
        mv.setCast(cast);
        mv.setCountry(country);
       
        movieRepository.save(mv);

}
}   */


}
}
