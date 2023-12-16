import { NextAuthOptions } from "next-auth";
import NextAuth from "next-auth/next";
import GithubProvider from "next-auth/providers/github";

const authOptions: NextAuthOptions = {
    providers: [
        GithubProvider({
            clientId: process.env.GITHUB_ID || "",
            clientSecret: process.env.GITHUB_SECRET || "",
            profile: (profile) => {
                return {
                    id: profile.id,
                    name: profile.name,
                    email: profile.email,
                    image: profile.avatar_url,
                    login: profile.login,
                };
            },
        }),
    ],
    callbacks: {
        async redirect({ baseUrl }) {
            return baseUrl + "/home";
        },
        async signIn({ user }) {
            console.log("user", user);

            return true;
        },
    },
};

const handler = NextAuth(authOptions);

export { handler as GET, handler as POST };
