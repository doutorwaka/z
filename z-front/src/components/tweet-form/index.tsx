"use client";

import { SplitedContainer } from "../splited-container";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { z } from "zod";
import {
    Form,
    FormControl,
    FormField,
    FormItem,
    FormMessage,
} from "../ui/form";
import { useSession } from "next-auth/react";
import { services } from "@/services";
import { AxiosError } from "axios";

const createTweetFormSchema = z.object({
    content: z.string().min(1).max(255),
});

type CreateTweetFormType = z.infer<typeof createTweetFormSchema>;

export function TweetForm() {
    const { data: session } = useSession();

    const userLogin = session?.user.login || "";

    const createTweetForm = useForm<CreateTweetFormType>({
        resolver: zodResolver(createTweetFormSchema),
        defaultValues: {
            content: "",
        },
    });

    async function handleCreateTweetFormSubmit({
        content,
    }: CreateTweetFormType) {
        const data = { content, userLogin };

        try {
            const response = await services.tweet.create(data);
            alert("Tweet criado com sucesso!");
            console.log(response);
        } catch (e) {
            const error = e as AxiosError;
            alert("Erro ao criar tweet!");
            console.log(error.message);
        }
    }

    return (
        <SplitedContainer>
            <Form {...createTweetForm}>
                <form
                    onSubmit={createTweetForm.handleSubmit(
                        handleCreateTweetFormSubmit
                    )}
                >
                    <div>
                        <FormField
                            name="content"
                            control={createTweetForm.control}
                            render={({ field }) => {
                                return (
                                    <FormItem>
                                        <FormControl>
                                            <Input
                                                type="text"
                                                placeholder="O que está acontecendo?"
                                                className="rounded-none text-xl font-light border-0 border-b-2 border-muted w-full focus-visible:ring-0 focus-visible:border-0"
                                                {...field}
                                            />
                                        </FormControl>
                                        <FormMessage />
                                    </FormItem>
                                );
                            }}
                        />
                    </div>
                    <div className="flex justify-end">
                        <Button className="w-32 rounded-full">Postar</Button>
                    </div>
                </form>
            </Form>
        </SplitedContainer>
    );
}
