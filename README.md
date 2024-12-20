# Role-Based Access Control (RBAC) in Spring Boot 3

Role-based Access Control (RBAC) is a security model that assigns permissions to users based on their roles. This enhances security, simplifies access management, and improves operational efficiency, especially in complex environments.

## Roles in the System

- **User:** Can access personal information.
- **Administrator:** Can perform User role actions and access the users' list.
- **Super Administrator:** Can perform Administrator role actions and create admin users; essentially has all permissions.

## Protected Routes

| Route             | Roles                      | Description                          |
|-------------------|----------------------------|--------------------------------------|
| [GET] /users/me   | User, Admin, Super Admin   | Retrieve the authenticated user.     |
| [GET] /users      | Admin, Super Admin         | Retrieve the list of all users.      |
| [POST] /admins    | Super Admin                | Create an administrator.             |

## Implementation Steps

1. **Protect API Routes for User and Admin Roles:**
   - For `/users/me`: Use `@PreAuthorize("isAuthenticated()")`.
   - For `/users`: Use `@PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")`.
     - Since `/users/me` is accessible by all roles, only check if the user is authenticated.

2. **Create the Role Entity and Data Access Layer:**
   - Define a `Role` entity and its corresponding repository to manage roles in the database.

3. **Associate the User Entity with Roles:**
   - Establish a relationship between the `User` entity and the `Role` entity to link users with their roles.

4. **Expose the User's Role in the Authentication Context:**
   - Ensure the user's roles are included in the authentication token for easy access during authorization.

5. **Enable Method Security in Spring Security:**
   - Activate method-level security annotations in Spring Security to protect routes based on roles.

6. **Protect API Routes with Method Security:**
   - Use `isAuthenticated()` to check if the user is logged in.
   - Use `hasRole()` or `hasAnyRole()` to authorize access based on roles.

## Conclusion

RBAC implementation in Spring Boot enhances security and simplifies permission management. By following the steps above, you can effectively secure your application's API routes and ensure that users access only the resources they are authorized for.
