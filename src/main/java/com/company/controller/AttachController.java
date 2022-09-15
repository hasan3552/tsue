package com.company.controller;

import com.company.dto.attach.AttachDTO;
import com.company.dto.product.ProductAttachDTO;
import com.company.dto.product.ProductDTO;
import com.company.service.AttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/attach")
public class AttachController {

    @Autowired
    private AttachService attachService;

//    @PostMapping("/upload")
//    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file,
//                                         HttpServletRequest request) {
//
//        Integer profileId = HttpHeaderUtil.getId(request);
//        AttachDTO dto = attachService.saveToSystem(file, profileId);
//        return ResponseEntity.ok().body(dto);
//    }d

//  ---------------------------  POST  ---------------------------------------

    @PostMapping("/upload/profile")
    public ResponseEntity<?> uploadProfile(@RequestParam("file") MultipartFile file) {

        AttachDTO dto = attachService.saveToSystemForProfile(file);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/adm/upload/factory/{key}")
    public ResponseEntity<?> uploadFactory(@RequestParam("file") MultipartFile file,
                                           @PathVariable("key") String key) {

        AttachDTO dto = attachService.saveToSystemForFactory(file, key);
        return ResponseEntity.ok().body(dto);
    }
    @PostMapping("/upload/product")
    public ResponseEntity<?> uploadProduct(@RequestPart("file") MultipartFile file,
                                           @RequestParam("productId")  String uuid) {


        ProductDTO dto = attachService.saveToSystemForProduct(file, uuid);
        return ResponseEntity.ok().body(dto);

//        Arrays
//        Array[] arrays = {a,d,a,r,v,d,s,v};

    }

//    @PostMapping("/upload/product")
//    public ResponseEntity<?> uploadProduct2(@RequestBody ProductAttachCreatedDTO dto) {
//
//        ProductDTO dto2 = attachService.saveToSystemForProduct(dto.getFiles(), dto.getProductId());
//        return ResponseEntity.ok().body(dto2);
//    }

    //  -------------------------  GET  ---------------------------------------
    @GetMapping(value = "/open", produces = MediaType.ALL_VALUE)
    public byte[] open_general(@RequestParam("fileId") String fileUUID) {
        return attachService.openGeneral(fileUUID);
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download(@RequestParam("fileId") String fileId) {

        Resource file = attachService.download(fileId);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);

    }

    //    @GetMapping(value = "/open/{fileId}", produces = MediaType.IMAGE_PNG_VALUE)
//    public byte[] open(@PathVariable("fileId") String fileName) {
//        if (fileName != null && fileName.length() > 0) {
//            try {
//                return this.attachService.loadImage(fileName);
//            } catch (Exception e) {
//                e.printStackTrace();
//                return new byte[0];
//            }
//        }
//        return null;
//    }

    // -------------------------    DELETED  ---------------------------------
    @DeleteMapping("/profile")
    public ResponseEntity<?> deletedProfile() {

        String response = attachService.deletedProfile();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/adm/factory")
    public ResponseEntity<?> deletedFactory(@RequestParam("key") String key) {

        String response = attachService.deletedFactory(key);

        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/product")
    public ResponseEntity<?> deletedProductAttach(@RequestBody @Valid ProductAttachDTO dto1,
                                                  @RequestParam String attachId,
                                                  HttpServletRequest request){
        // attachService.deletedProductAttach(profileId,attachId,dto1);

        return ResponseEntity.ok().build();
    }

    // -----------------------  PAGINATION  ----------------------------------------
    @GetMapping("/adm/pagination")
    public ResponseEntity<?> pagination(@RequestParam("page") Integer page,
                                        @RequestParam("size") Integer size) {
        PageImpl pagination = attachService.pagination(page, size);

        return ResponseEntity.ok(pagination);
    }


}
