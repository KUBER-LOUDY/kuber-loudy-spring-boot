package com.kuberloudy.oci.controller;

import com.kuberloudy.oci.service.OciService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/oci" ,produces = "application/json; charset=utf8")
public class OciObjectController {

    private final OciService ociService;
    private final String urlPrefix = "https://objectstorage.us-ashburn-1.oraclecloud.com";

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file){
        try {
            ociService.upload(file);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/configfileurl")
    public ResponseEntity<Object> getURl() {
        try {
            String accessUri = ociService.getConfigFile()
                    .getPreauthenticatedRequest().getAccessUri();
            return ResponseEntity.ok().body(urlPrefix + accessUri);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
