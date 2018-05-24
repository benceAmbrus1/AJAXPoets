function showContents(ids) {
    const contentEls = document.getElementsByClassName('content');
    for (let i = 0; i < contentEls.length; i++) {
        const contentEl = contentEls[i];
        if (ids.includes(contentEl.id)) {
            contentEl.classList.remove('hidden');
        } else {
            contentEl.classList.add('hidden');
        }
    }
}

function showPoem(id) {
    const contentEls = document.getElementsByClassName('poem');
    for (let i = 0; i < contentEls.length; i++) {
        const contentEl = contentEls[i];
        if (id == contentEl.id) {
            contentEl.classList.remove('hidden');
        } else {
            contentEl.classList.add('hidden');
        }
    }
}

function removeAllChildren(el) {
    while (el.firstChild) {
        el.removeChild(el.firstChild);
    }
}


function onSearchClicked(){
}

function createSearchButton(id){
    const DivEl = document.createElement('div');

    const inputEl = document.createElement("input");
    inputEl.setAttribute('type', 'text');
    inputEl.setAttribute('value', 'Search');

    const buttonEl = document.createElement('button');
    const idAttrEl = document.createAttribute('poem-id-searchButton');
    idAttrEl.value = id;
    buttonEl.textContent = "Search";
    buttonEl.setAttributeNode(idAttrEl);
    buttonEl.addEventListener('click', onSearchClicked)

    DivEl.appendChild(inputEl);
    DivEl.appendChild(buttonEl);

    return DivEl;
}
