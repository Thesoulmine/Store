async function addListingButton() {
    const toBase64 = file => new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => resolve(reader.result
            .replace('data:', '')
            .replace(/^.+,/, ''));
        reader.onerror = error => reject(error);
    });

    let formData = new FormData();
    let listing = {
        title: addListingForm.title.value,
        category: {
            id: addListingForm.category.value
        },
        description: addListingForm.description.value,
        material: addListingForm.material.value,
        colours: addListingForm.colours.value.split(',').map(element => element.trim()),
        price: addListingForm.price.value
    }
    formData.append('listing',
        new Blob([JSON.stringify(listing)], {
            type: 'application/json'
    }));
    for (let i = 0; i < addListingForm.images.files.length; i++) {
        formData.append('files', addListingForm.images.files[i], addListingForm.images.files[i].name);
    }
    let response = await fetch("http://localhost:8081/api/listings", {
        method: 'POST',
        body: formData
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