package com.macalicestore.listing.listingsgroup;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listings-groups")
public class ListingsGroupController {

    private final ListingsGroupService listingsGroupService;

    private final ListingsGroupMapper listingsGroupMapper;

    public ListingsGroupController(ListingsGroupService listingsGroupService,
                                   ListingsGroupMapper listingsGroupMapper) {
        this.listingsGroupService = listingsGroupService;
        this.listingsGroupMapper = listingsGroupMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<ListingsGroupDTO>> getAllListingsGroups() {
        return new ResponseEntity<>(
                listingsGroupMapper.toDTO(
                        listingsGroupService.getAllListingsGroups()),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListingsGroupDTO> getListingsGroup(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                listingsGroupMapper.toDTO(
                        listingsGroupService.getListingsGroupById(id)),
                HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ListingsGroupDTO> addNewListingsGroup(@RequestBody ListingsGroupDTO listingsGroupDTO) {
        return new ResponseEntity<>(
                listingsGroupMapper.toDTO(
                        listingsGroupService.saveListingsGroup(
                                listingsGroupMapper.toEntity(listingsGroupDTO))),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListingsGroup(@PathVariable("id") Long id) {
        listingsGroupService.deleteListingsGroupById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListingsGroupDTO> updateListingsGroup(
            @PathVariable Long id, @RequestBody ListingsGroupDTO listingsGroupDTO) {
        return new ResponseEntity<>(
                listingsGroupMapper.toDTO(
                        listingsGroupService.updateListingsGroup(
                                listingsGroupMapper.toEntity(listingsGroupDTO), id)),
                HttpStatus.OK);
    }
}
