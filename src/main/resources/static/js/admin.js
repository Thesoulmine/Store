async function addListingButton() {
    let formData = new FormData();
    let images = []
    for (let i = 0; i < addListingForm.images.files.length; i++) {
        let image = {
            imageType: 'NEW',
            image: addListingForm.images.files[i]
        }
        images.push(image);
    }
    let listing = {
        //title: addListingForm.title.value,
        category: {
            id: addListingForm.category.value
        },
        //description: addListingForm.description.value,
        //material: addListingForm.material.value,
        //colours: addListingForm.colours.value.split(',').map(element => element.trim()),
        //price: addListingForm.price.value,
        listingType: 'PHYSICAL'
    }
    formData.append('listing',
        new Blob([JSON.stringify(listing)], {
            type: 'application/json'
    }));
    for (let i = 0; i < addListingForm.images.files.length; i++) {
        formData.append('images', addListingForm.images.files[i], addListingForm.images.files[i].name);
    }
     await fetch("http://localhost:8080/api/listings", {
        method: 'POST',
        body: formData
    });
    addListingForm.reset();
}

async function addCategories() {
    let response = await fetch("http://localhost:8080/api/listings/categories");
    let commits = await response.json();
    let li = ``;
    commits.forEach(element => {
        li += `<option value="${element.id}">${element.name}</option>`
    });
    document.getElementById("categoryFormSelect").innerHTML = li;
}

window.onload = function() {
    addCategories();
};