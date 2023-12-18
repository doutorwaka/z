import { services } from "@/services";
import { NextAuthOptions } from "next-auth";
import NextAuth from "next-auth/next";
import GithubProvider from "next-auth/providers/github";

export const authOptions: NextAuthOptions = {
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
    pages: {
        error: "/error",
    },
    callbacks: {
        redirect({ baseUrl }) {
            return baseUrl + "/home";
        },
        jwt({ token, profile }) {
            if (profile) {
                token.login = profile.login;
            }
            return token;
        },
        session({ session, token }) {
            if (token) {
                if (token.login) {
                    session.user.login = token.login;
                }
            }
            return session;
        },
        async signIn({ user }) {
            if (!user) {
                return false;
            }

            const name = user.name;
            const email = user.email;
            const login = user.login;

            try {
                await services.auth.createProfileIfNotExists({
                    name,
                    email,
                    login,
                });
            } catch (e) {
                return false;
            }

            return true;
        },
    },
};

const handler = NextAuth(authOptions);

export { handler as GET, handler as POST };
