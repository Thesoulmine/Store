async function addListingButton() {
    const toBase64 = file => new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => resolve(reader.result
            .replace('data:', '')
            .replace(/^.+,/, ''));
        reader.onerror = error => reject(error);
    });

    let listing = {
        title: addListingForm.title.value,
        category: {
            id: addListingForm.category.value
        },
        description: addListingForm.description.value,
        material: addListingForm.material.value,
        colours: addListingForm.colours.value.split(',').map(element => element.trim()),
        price: addListingForm.price.value,
        images: Array()
    }
    for (let i = 0; i < addListingForm.images.files.length; i++) {
        listing.images.push({
            "name": addListingForm.images.files[i].name,
            "type": addListingForm.images.files[i].type,
            "content": await toBase64(addListingForm.images.files[i])
        })
    }
    // Array.from(addListingForm.images.files).map(async function (file) {
    //     listing.images.push({
    //
    //     });
    // });
    let response = await fetch("http://localhost:8081/api/listings", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(listing)
    });
    console.log(listing);
    addListingForm.reset();
}

async function addCategories() {
    let response = await fetch("http://localhost:8081/api/listings/categories");
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