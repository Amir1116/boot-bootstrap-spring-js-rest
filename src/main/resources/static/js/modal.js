class Modal {
    btnText;
    constructor(id, title, content, btnClass, btnform, btnText) {
        this.btnText = btnText;
        this.id = id;
        this.title = title;
        this.content = content;
        this.btnClass = btnClass;
        this.btnform = btnform;
    }

    createModal() {
        return `<div class="modal p-5 fade" tabIndex="-1" id="${this.id}">
        <div class="modal-dialog">
            <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">${this.title}</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body" style="width: 50%; margin:auto;">
                       ${this.content}
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary"  data-bs-dismiss="modal">Close</button>
                        <button type="button" class="${this.btnClass}"  data-bs-dismiss="modal">${this.btnText}</button>                        
                    </div>
                </div>
            </div>
        </div>`;
    }
}
