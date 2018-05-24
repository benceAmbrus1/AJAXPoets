let profileEl;
let worksEl;

function onLoadFullPoem(){
    const id = this.getAttribute('poem-id-onButton');
    showContents(['profile', 'works', 'search']);
    showPoem(id);
}

function listPoems(poems){
    const ulEl = document.createElement('ul');

    for(let i=0; i<poems.length; i++){
        const poem = poems[i];
        const liEl = document.createElement('li');

        const poemIDAttr = document.createAttribute('poem-id-onButton');
        poemIDAttr.value = poem.id;
        const titleButtonEl = document.createElement('button')
        titleButtonEl.textContent = poem.title;
        titleButtonEl.setAttributeNode(poemIDAttr);
        titleButtonEl.addEventListener('click', onLoadFullPoem);

        const fullPoemDivEl = document.createElement('div');
        fullPoemDivEl.id = poem.id;
        fullPoemDivEl.textContent = poem.poem;
        fullPoemDivEl.classList.add("hidden");
        fullPoemDivEl.classList.add("poem");
        fullPoemDivEl.appendChild(createSearchButton(poem.id));

        liEl.appendChild(titleButtonEl);
        liEl.appendChild(fullPoemDivEl);

        ulEl.appendChild(liEl);
    }
    return ulEl;
}

function onPoemsReceived(){
    showContents(['profile', 'works']);

    const poems = JSON.parse(this.responseText);
    removeAllChildren(worksEl);
    worksEl.appendChild(listPoems(poems));
}

function onLoadPoems(){
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onPoemsReceived);
    xhr.open('GET', 'protected/poems');
    xhr.send();
}

function onLoad(){
    profileEl = document.getElementById('profile');
    worksEl = document.getElementById('works-content');

    onLoadPoems();
}

document.addEventListener('DOMContentLoaded', onLoad);
