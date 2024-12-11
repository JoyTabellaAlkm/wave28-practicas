package co.mercadolibre.linktracker.controller;

import co.mercadolibre.linktracker.dto.RequestLinkDTO;
import co.mercadolibre.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class LinkController {

    @Autowired
    ILinkService ls;

    @PostMapping("link/")
    public ResponseEntity<Integer> createLink(@RequestBody RequestLinkDTO linkDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(ls.createLink(linkDTO));
    }

    @GetMapping("link/{id}")
    public RedirectView getURL(@PathVariable int id, @RequestParam(required = false) String password){
        return new RedirectView(ls.getURL(id, password));
    }

    @GetMapping("metrics/{linkID}")
    public ResponseEntity<?> getLinkMetrics(@PathVariable int linkID){
        return ResponseEntity.ok(ls.getMetrics(linkID));
    }

    @PostMapping("invalidate/{linkID}")
    public ResponseEntity<?> invalidateLink(@PathVariable int linkID){
        return ResponseEntity.ok(ls.deleteLink(linkID));
    }

}
