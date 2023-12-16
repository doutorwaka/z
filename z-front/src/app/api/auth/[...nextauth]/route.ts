import { NextAuthOptions } from "next-auth";
import NextAuth from "next-auth/next";
import GithubProvider from "next-auth/providers/github";

const authOptions: NextAuthOptions = {
    providers: [
        GithubProvider({
            clientId: process.env.GITHUB_ID || "",
            clientSecret: process.env.GITHUB_SECRET || "",
        }),
    ],
    callbacks: {
        async redirect({ baseUrl }) {
            return baseUrl + "/home";
        },
    },
};

const handler = NextAuth(authOptions);

export { handler as GET, handler as POST };
