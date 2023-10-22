//    package com.resourciumoptima.resourcium_optima.services;
//
//    import com.resourciumoptima.resourcium_optima.enums.Role;
//    import com.resourciumoptima.resourcium_optima.models.entities.User;
//    import com.resourciumoptima.resourcium_optima.repositories.UserRepo;
//    import com.resourciumoptima.resourcium_optima.repositories.impl.UserRepoImpl;
//    import jakarta.servlet.annotation.WebServlet;
//    import jakarta.servlet.http.HttpServlet;
//    import jakarta.servlet.http.HttpServletRequest;
//    import jakarta.servlet.http.HttpServletResponse;
//    import org.mindrot.jbcrypt.BCrypt;
//
//    import java.io.IOException;
//
//
//    @WebServlet(name = "signup" , urlPatterns = {"*.u"})
//    //@RequiredArgsConstructor
//    public class SingUp extends HttpServlet {
//
//
//        private final UserRepo userRepo;
//
//        public SingUp(){
//            this.userRepo = new UserRepoImpl();
//        }
//
//        @Override
//        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//            User user = new User();
//            String path = request.getServletPath();
//            System.out.println(path);
//            switch (path){
//                case "/login/add.u":
//                    user.setName(request.getParameter("name"));
//                    user.setEmail( request.getParameter("email"));
//                    user.setPassword(hashPassword(request.getParameter("password")));
//                    user.setLastName(request.getParameter("lastName"));
//                    user.setRole(Role.ADMIN);
//
//                    userRepo.save(user);
//                    break;
//                case "/login/signin.u":
//                    String email = request.getParameter("email");
//                    String password = request.getParameter("password");
//
//                    userRepo.singIn(email,password);
//                    break;
//            }
//        }
//        public String hashPassword(String password) {
//            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
//            return hashedPassword;
//        }
//    }
