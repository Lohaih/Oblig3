package org.example.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillettController {

    @Autowired
    BillettRepository rep;

    @PostMapping("/lagre")
    public void lagreBillett(Billett innBillett) {
        rep.lagreBillett(innBillett);
    }

    @GetMapping("/hentBilletter")
    public List<Billett> hentBilletter() {
        return rep.hentBilletter();
    }

    @GetMapping("/slettBilletter")
    public void slettBilletter() {
        rep.slettBilletter();
    }

    @DeleteMapping("/slettBillett")
    public void slettBillett(@RequestParam("id") int innId) {
        rep.slettBillett(innId);
    }

    @GetMapping("/hentBillett")
    public Billett hentBillett(@RequestParam("id") int innId) {
        return rep.hentBillett(innId);
    }

    @PostMapping("/endreBillett")
    public void endreBillett(@RequestBody Billett innBillett) {
        rep.endreBillett(innBillett);
    }

}
