$(document).ready(function() {
                $("#table-user").DataTable({
                buttons : [ {
                extend : "copy",
                className : "btn-sm"
                }, {
                extend : "excel",
                className : "btn-sm"
                }, {
                extend : "print",
                className : "btn-sm"
                }, ]
                });

                $("#roles, #edit-roles").chosen({
                width : "100%",
                placeholder_text_multiple : "Chọn chức vụ"
                });

                $.uploadPreview({
                input_field : "#img-upload", // Default: .image-upload
                preview_box : "#img-preview", // Default: .image-preview
                label_field : "#image-label", // Default: .image-label
                label_default : "Choose File", // Default: Choose File
                label_selected : "Change File", // Default: Change File
                no_label : true
                });

                $.uploadPreview({
                input_field : "#edit-img-upload",
                preview_box : "#edit-img-preview",
                label_field : "#image-label",
                label_default : "Choose File",
                label_selected : "Change File",
                no_label : true
                });

                });

                function generatePassword() {
                $("#password, #edit-password").val(randomPass());
                }

                function randomPass() {
                //(Math.random() + 1).toString(36).substring(2, 7)
                var text = "";
                var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

                for (var i = 0; i < 5; i++)
                text += possible.charAt(Math.floor(Math.random()
                * possible.length));

                return text;
                }

                function openFileDialog() {
                $("#img-upload").trigger("click");
                }

                function openFileDialog2() {
                $("#edit-img-upload").trigger("click");
                }

                function editUser(id, fullName, userName, roles, boPhan){

                $("#edit-roles option").each(function(){
                $(this).removeAttr("selected");
                });

                $("#edit-id").val(id);
                $("#edit-fullName").val(fullName);
                $("#edit-userName").val(userName);

                $("#edit-roles").val(roles);
                $("#edit-roles").trigger("chosen:updated");
                $("#edit-bp").val(boPhan).change();

                //$("#img-preview").css("background-image", "url('resources/images/user.jpg')");
                $("#edit-img-preview").css("background-image", "url('resources/images/user.jpg')");

                }


