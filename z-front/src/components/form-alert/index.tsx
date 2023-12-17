import { AlertCircle, CheckIcon, LucideIcon } from "lucide-react";
import { ReactComponentElement } from "react";
import { Alert, AlertDescription, AlertTitle } from "../ui/alert";
import { cn } from "@/utils/utils";

export type FormAlertProps = {
    message: string;
    type: "success" | "error";
    className?: string;
};

export function FormAlert({ message, type, className="" }: FormAlertProps) {
    const configuration = type === "success" ? SucessAlert() : ErrorAlert();

    return (
        <Alert variant={"default"} className={cn(configuration.className, className)}>
            {configuration.icon}
            <AlertTitle>{configuration.title}</AlertTitle>
            <AlertDescription>{message}</AlertDescription>
        </Alert>
    );
}

type AlertConfigurationProps = {
    title: string;
    icon: ReactComponentElement<LucideIcon>;
    className: string;
};

function SucessAlert(): AlertConfigurationProps {
    return {
        title: "Sucesso!",
        icon: <CheckIcon className="stroke-green-500 h-4 w-4" />,
        className: "border-green-500",
    };
}

function ErrorAlert(): AlertConfigurationProps {
    return {
        title: "Erro!",
        icon: <AlertCircle className="stroke-red-500 h-4 w-4" />,
        className: "border-red-500",
    };
}
