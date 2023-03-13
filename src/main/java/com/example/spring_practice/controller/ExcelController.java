package com.example.spring_practice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/excel")
public class ExcelController {
    private final String uploadDir = "/Users/ijiyun/Documents/etc/file/";
    @PostMapping(value = "/upload")
    public String uploadExcel(@ModelAttribute MultipartFile request) throws IOException {
//        log.info("중간 체크 : " + request.toString());
        Resource excelFile =request.getResource();
        InputStream tmp = excelFile.getInputStream();
//        File destFile = new File(uploadDir + request.getOriginalFilename());
//        request.transferTo(destFile);
        log.info("name: " +request.getOriginalFilename());
        log.info("test2 " + request.getResource());

        try {
//엑셀 파일 주소를 담습니다. (xls경우)
//            FileInputStream file = new FileInputStream(tmp);
            XSSFWorkbook excelfile = new XSSFWorkbook(tmp);

//xlsx라면 아래 사용 필요합니다.
//XSSFWorkbook workbook = new XSSFWorkbook(file);

            HashMap<Integer, String> excelMap = new HashMap<Integer, String>(); // 값을 담을 변수 설정
            List<HashMap<Integer, String>> excelList = new ArrayList<HashMap<Integer, String>>(); //값을 담은 맵을 리스트화

            int rowindex=0;
            int columnindex=0;
            DecimalFormat df = new DecimalFormat();

//시트를 읽습니다.
            XSSFSheet sheet=excelfile.getSheetAt(0);

//행의 수를 체크해줍니다.
            int rows=sheet.getPhysicalNumberOfRows();
            for(rowindex=0;rowindex<rows;rowindex++){

                if(rowindex > 2) {
                    excelList.add(excelMap);
                    excelMap = new HashMap<Integer, String>();
                }

                //행을 읽습니다.
                XSSFRow row=sheet.getRow(rowindex);
                if(row !=null){
                    //셀의 수를 체크해줍니다.
                    int cells=row.getPhysicalNumberOfCells();
                    log.info("중간 체크 2: " + cells);

                    for(columnindex=0; columnindex<=cells-1; columnindex++){
                        //셀값을 확인합니다.
                        XSSFCell cell=row.getCell(columnindex);
                        String value="";
                        if(cell==null){
                            excelMap.put(columnindex, value);
                            continue;
                        }else{
                            //타입별로 value에 값을 넣어줍니다.
                            switch (cell.getCellType()){
                                case XSSFCell.CELL_TYPE_FORMULA:
                                    value=cell.getCellFormula();
                                    break;
                                case XSSFCell.CELL_TYPE_NUMERIC:
//                                    if( HSSFDateUtil.isCellDateFormatted(cell) ) {
//                                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                                        value = formatter.format(cell.getDateCellValue());
//                                    }
//                                    else {
                                        double ddata = Double.valueOf( cell.getNumericCellValue() ).intValue();
                                        value = df.format(ddata);
//                                    }
                                    break;
                                case XSSFCell.CELL_TYPE_STRING:
                                    value=cell.getStringCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_BLANK:
                                    value=cell.getBooleanCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_ERROR:
                                    value=cell.getErrorCellValue()+"";
                                    break;
                            }
                        }

                        //map에 데이터를 담습니다.
                        excelMap.put(columnindex, value);


                        log.info(rowindex+" 행 : "+columnindex+"번째의 값은: "+value);
                    }

                }

            }

//데이터 추출


        }catch(Exception e) {
            e.printStackTrace();
        }


        return "성공";
    }
}
