class User{
        constructor(id, email, password, username, name, lastName, age, roleList, isAdmin) {
                this.id = id;
                this.email = email;
                this.password = password;
                this.username = username;
                this.name = name;
                this.lastName = lastName;
                this.age = age;
                this.roleList = roleList;

        };

        showRole(){
                return this.roleList;
        }

        static userFromFrom(formName){
                const form = document.forms.namedItem(formName);
                const formData = new FormData(form);
                console.log(formData.get("id"));
                const roles = formData.getAll('roles').map(role => Role.createRole(role).toJSON());
                return new User(formData.get("id"),
                                formData.get("email"),
                                formData.get("password"),
                                formData.get("username"),
                                formData.get("name"),
                                formData.get("lastName"),
                                formData.get("age"),
                                roles);

        }

        toJSON() {
                return {
                        "id": this.id,
                        "email": this.email,
                        "password": this.password,
                        "username": this.username,
                        "name": this.name,
                        "lastName": this.lastName,
                        "age": this.age,
                        "roleList": this.roleList,
                }
        }
}



