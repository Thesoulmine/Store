package com.macalicestore.listing.listingsgroup;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listings-groups")
public class ListingsGroupController {

    private final ListingsGroupService listingsGroupService;

    public ListingsGroupController(ListingsGroupService listingsGroupService) {
        this.listingsGroupService = listingsGroupService;
    }

    @GetMapping("")
    public ResponseEntity<List<ListingsGroup>> getAllListingsGroups() {
        return new ResponseEntity<>(listingsGroupService.getAllListingsGroups(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListingsGroup> getListingsGroup(@PathVariable("id") Long id) {
        return new ResponseEntity<>(listingsGroupService.getListingsGroupById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> addNewListingsGroup(@RequestBody ListingsGroupDTO listingsGroupDTO) {
        listingsGroupService.saveListingsGroup(listingsGroupDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
