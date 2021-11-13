class Form{
    constructor(idform, formName, idSuffix , idValue, firstname, lastname, age, email, username, dis) {
        this.idform = idform;
        this.formName = formName;
        this.idSuffix = idSuffix;
        this.idValue = idValue;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.username = username;
        this.dis = dis;
    }

    createForm() {
       let fieldsetBegin = this.dis === 'disabled'?` <fieldset disabled>`:'';
       let fieldsetEnd = this.dis === 'disabeld'? `</fieldset>`:'';
    return ` <form  id=${this.idform} name=${this.formName} disabled>
            <input type="text" value=${this.idValue?this.idValue:null} style="visibility:hidden;" name="id">
  ${fieldsetBegin}
        <div class="mb-3">
          
            <label for="inptId${this.idSuffix}" class="form-label fw-bold text-center w-100">ID</label>
            <input type="text" class="form-control mb-3" value="${this.idValue}" name="id"
                   disabled id="inptId${this.idSuffix}"/>
        </div>
        <div class="mb-3">
            <label for="inptName${this.idSuffix}" class="form-label fw-bold text-center w-100">First
                Name</label>
            <input type="text" class="form-control mb-3" value="${this.firstname}"
                   id="inptName${this.idSuffix}" required name="name"/>
        </div>
        <div class="mb-3">
            <label for="inptLastName${this.idSuffix}" class="form-label fw-bold text-center w-100">Last
                Name</label>
            <input name="lastName" type="text" class="form-control" value="${this.lastname}"
                   id="inptLastName${this.idSuffix}" required/>
        </div>
        <div class="mb-3">
            <label class="form-check-label fw-bold text-center w-100" for="inptAge${this.idSuffix}">Age</label>
            <input name="age" type="number" class="form-control" value="${this.age}"
                    id="inptAge${this.idSuffix}" required/>
        </div>

        <div class="mb-3">
            <label class="form-check-label fw-bold text-center w-100"
                   for="inptUsername${this.idSuffix}">username
            </label>
            <input name="username" type="text" class="form-control" value="${this.username}"
                    id="inptUsername${this.idSuffix}" required/>
        </div>

        <div class="mb-3">
            <label class="form-check-label fw-bold text-center w-100" for="inptEmail${this.idSuffix}">Email
            </label>
            <input name="email" type="text" class="form-control" value="${this.email}"
                    id="inptEmai${this.idSuffix}" required/>
        </div>

        <div class="mb-3">
            <label class="form-check-label fw-bold text-center w-100" for="inptPassword${this.idSuffix}">Password
            </label>
            <input name="password" type="password" class="form-control" 
                   id="inptPassword${this.idSuffix}" required/>
        </div>

        <div class="mb-3">
            <label class="form-check-label fw-bold text-center w-100" for="role${this.idSuffix}">Role</label>
            <select id="role${this.idSuffix}" name="roles" multiple 
                    class="form-select"
                    required aria-label="multiple select example">
                <option value="ADMIN">ADMIN</option>
                <option value="USER">USER</option>
            </select>
        </div>
        ${fieldsetEnd}
    </form>
`
}

}

